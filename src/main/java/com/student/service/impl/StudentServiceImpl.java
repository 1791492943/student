package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.bo.StudentBo;
import com.student.domain.entity.Class;
import com.student.domain.entity.Student;
import com.student.domain.entity.StudentClass;
import com.student.domain.vo.StudentVo;
import com.student.mapper.ClassMapper;
import com.student.mapper.StudentClassMapper;
import com.student.service.StudentService;
import com.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author 17914
* @description 针对表【student(学生表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentClassMapper studentClassMapper;

    @Override
    public List<StudentVo> getStudentVoList(StudentBo bo) {
        List<Student> student = baseMapper.getSutdent(bo);
        if(student.isEmpty()) return List.of();

        List<Class> classList = classMapper.selectList(null);
        List<StudentClass> studentClassList = studentClassMapper.selectList(null);

        return student.stream().map(stu -> {
            StudentVo studentVo = new StudentVo();
            studentVo.setStudent(stu);

            List<Long> cids = studentClassList.stream()
                    .filter(item -> item.getStudentId().equals(stu.getId()))
                    .map(StudentClass::getClassId)
                    .toList();

            List<Class> cs = classList.stream()
                    .filter(item -> cids.contains(item.getId()))
                    .toList();
            studentVo.setClassList(cs);
            return studentVo;
        }).toList();
    }
}




