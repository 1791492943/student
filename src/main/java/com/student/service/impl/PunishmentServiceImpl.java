package com.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.entity.Class;
import com.student.domain.entity.Punishment;
import com.student.domain.entity.Student;
import com.student.domain.entity.StudentPunishment;
import com.student.domain.vo.PunishmentVo;
import com.student.domain.vo.StudentPunishmentVo;
import com.student.mapper.*;
import com.student.service.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
* @author 17914
* @description 针对表【punishment(处分表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class PunishmentServiceImpl extends ServiceImpl<PunishmentMapper, Punishment>
    implements PunishmentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentPunishmentMapper studentPunishmentMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentClassMapper studentClassMapper;

    @Override
    public void saveList(StudentPunishmentVo sp) {
        if(sp.getStudentIds().size() > 1){
            List<Long> list = sp.getStudentIds();
            List<Student> students = studentMapper.selectBatchIds(list);
            Set<Integer> collect = students.stream().map(Student::getLevel).collect(Collectors.toSet());
            if(collect.size() > 1){
                throw new RuntimeException("处分等级不一致 无法批量操作");
            }
        }

        //todo 查出学生 然后设置StudentPunishment


//        for (StudentPunishment studentPunishment : sp) {
//            studentPunishmentMapper.insert(studentPunishment);
//            Student student = new Student();
//            student.setId(studentPunishment.getStudentId());
//            student.setLevel(studentPunishment.getPunishmentLevel());
//            studentMapper.updateById(student);
//        }
    }

    @Override
    public void removeId(Long id) {
        //todo 删除需要校验 只能从给最后一个开始删除
        studentPunishmentMapper.deleteById(id);
    }

    @Override
    public List<PunishmentVo> list(Long studentId) {
        List<StudentPunishment> studentPunishments = studentPunishmentMapper.selectList(
                new LambdaQueryWrapper<StudentPunishment>()
                        .eq(studentId != null, StudentPunishment::getStudentId, studentId)
                        .orderByDesc(StudentPunishment::getPunishmentTime)
        );
        if(studentPunishments.isEmpty()) return List.of();

        Map<Long, Student> studentMap = new HashMap<>();
        studentMapper.selectList(null).forEach(student -> studentMap.put(student.getId(), student));

        Map<Long, Class> classMap = new HashMap<>();
        classMapper.selectList(null).forEach(c -> classMap.put(c.getId(),c));

        Map<Integer,Punishment> punishmentMap = new HashMap<>();
        baseMapper.selectList(null).forEach(p -> punishmentMap.put(p.getLevel(),p));

        Map<Long,List<Class>> studentClassMap = new HashMap<>();
        studentClassMapper.selectList(null).forEach(sc ->
                studentClassMap.computeIfAbsent(sc.getStudentId(), k->new ArrayList<>()).add(classMap.get(sc.getClassId())));

        return studentPunishments.stream().map(item -> {
            PunishmentVo punishmentVo = new PunishmentVo();
            punishmentVo.setStudentPunishment(item);
            punishmentVo.setStudent(studentMap.get(item.getStudentId()));
            punishmentVo.setPunishment(punishmentMap.get(item.getPunishmentLevel()));
            punishmentVo.setClassList(studentClassMap.get(item.getStudentId()));
            return punishmentVo;
        }).toList();
    }
}




