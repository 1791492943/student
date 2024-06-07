package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.entity.Punishment;
import com.student.domain.entity.Student;
import com.student.domain.entity.StudentPunishment;
import com.student.mapper.StudentMapper;
import com.student.mapper.StudentPunishmentMapper;
import com.student.service.PunishmentService;
import com.student.mapper.PunishmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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

    @Override
    public void saveList(List<StudentPunishment> sp) {
        if(sp.size() > 1){
            List<Long> list = sp.stream().map(StudentPunishment::getStudentId).toList();
            List<Student> students = studentMapper.selectBatchIds(list);
            Set<Integer> collect = students.stream().map(Student::getLevel).collect(Collectors.toSet());
            if(collect.size() > 1){
                throw new RuntimeException("处分等级不一致 无法批量操作");
            }
        }

        for (StudentPunishment studentPunishment : sp) {
            studentPunishmentMapper.insert(studentPunishment);
            Student student = new Student();
            student.setId(studentPunishment.getStudentId());
            student.setLevel(studentPunishment.getPunishmentLevel());
            studentMapper.updateById(student);
        }
    }

    @Override
    public void removeId(Long id) {
        //todo 删除需要校验 只能从给最后一个开始删除
        studentPunishmentMapper.deleteById(id);
    }
}




