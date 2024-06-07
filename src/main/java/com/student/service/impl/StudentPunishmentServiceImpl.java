package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.entity.StudentPunishment;
import com.student.service.StudentPunishmentService;
import com.student.mapper.StudentPunishmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 17914
* @description 针对表【student_punishment(学生处分关联表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class StudentPunishmentServiceImpl extends ServiceImpl<StudentPunishmentMapper, StudentPunishment>
    implements StudentPunishmentService{

}




