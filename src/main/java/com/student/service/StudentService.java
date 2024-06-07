package com.student.service;

import com.student.domain.bo.StudentBo;
import com.student.domain.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.vo.StudentVo;

import java.util.List;

/**
* @author 17914
* @description 针对表【student(学生表)】的数据库操作Service
* @createDate 2024-06-05 20:38:45
*/
public interface StudentService extends IService<Student> {

    List<StudentVo> getStudentVoList(StudentBo bo);
}
