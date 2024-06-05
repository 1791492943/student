package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.Class;
import com.student.service.ClassService;
import com.student.mapper.ClassMapper;
import org.springframework.stereotype.Service;

/**
* @author 17914
* @description 针对表【class(班级表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class>
    implements ClassService{

}




