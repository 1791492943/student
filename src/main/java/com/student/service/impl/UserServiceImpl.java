package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.User;
import com.student.service.UserService;
import com.student.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 17914
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




