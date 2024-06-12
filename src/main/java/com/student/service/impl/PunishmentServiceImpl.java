package com.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
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
        implements PunishmentService {

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
        List<Student> students = studentMapper.selectBatchIds(sp.getStudentIds());
        for (Student student : students) {
            StudentPunishment studentPunishment = new StudentPunishment();
            studentPunishment.setStudentId(student.getId());
            studentPunishment.setCriticism(sp.getCriticism());
            studentPunishment.setRemark(sp.getRemark());
            studentPunishment.setYear(sp.getYear());
            studentPunishment.setSemester(sp.getSemester());
            studentPunishment.setPunishmentTime(sp.getPunishmentTime());
            //设置等级
            if (sp.getCriticism() == 1) {
                LambdaQueryWrapper<StudentPunishment> qw = new LambdaQueryWrapper<>();
                qw.eq(StudentPunishment::getStudentId, student.getId());
                qw.eq(StudentPunishment::getYear, sp.getYear());
                qw.eq(StudentPunishment::getSemester, sp.getSemester());
                Long count = studentPunishmentMapper.selectCount(qw);
                studentPunishment.setChange(count % 2 == 1 ? "up" : "noChange");
                studentPunishment.setPunishmentLevel(count % 2 == 1 ? student.getLevel() + 1 : student.getLevel());
            } else {
                studentPunishment.setPunishmentLevel(student.getLevel() + sp.getChangeLevel());
                studentPunishment.setChange(sp.getChangeLevel() < 0 ? "down" : "up");
            }
        }


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
    public List<PunishmentVo> list(String studentCode) {
        List<Student> students = studentMapper.selectList(new LambdaQueryWrapper<Student>().eq(ObjectUtils.isNotEmpty(studentCode), Student::getStudentCode, studentCode));
        if(students.isEmpty()) return new ArrayList<>();
        List<Long> idList = students.stream().map(Student::getId).toList();

        List<StudentPunishment> studentPunishments = studentPunishmentMapper.selectList(
                new LambdaQueryWrapper<StudentPunishment>()
                        .in(StudentPunishment::getStudentId, idList)
                        .orderByDesc(StudentPunishment::getPunishmentTime)
        );
        if (studentPunishments.isEmpty()) return List.of();

        Map<Long, Student> studentMap = new HashMap<>();
        studentMapper.selectList(null).forEach(student -> studentMap.put(student.getId(), student));

        Map<Long, Class> classMap = new HashMap<>();
        classMapper.selectList(null).forEach(c -> classMap.put(c.getId(), c));

        Map<Integer, Punishment> punishmentMap = new HashMap<>();
        baseMapper.selectList(null).forEach(p -> punishmentMap.put(p.getLevel(), p));

        Map<Long, List<Class>> studentClassMap = new HashMap<>();
        studentClassMapper.selectList(null).forEach(sc ->
                studentClassMap.computeIfAbsent(sc.getStudentId(), k -> new ArrayList<>()).add(classMap.get(sc.getClassId())));

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




