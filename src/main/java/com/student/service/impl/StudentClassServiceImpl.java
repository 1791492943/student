package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.StudentClass;
import com.student.service.StudentClassService;
import com.student.mapper.StudentClassMapper;
import org.springframework.stereotype.Service;

/**
* @author 17914
* @description 针对表【student_class(学生班级关联表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class StudentClassServiceImpl extends ServiceImpl<StudentClassMapper, StudentClass>
    implements StudentClassService{

}




