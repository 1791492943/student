package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.Student;
import com.student.service.StudentService;
import com.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author 17914
* @description 针对表【student(学生表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




