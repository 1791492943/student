package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.Punishment;
import com.student.service.PunishmentService;
import com.student.mapper.PunishmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 17914
* @description 针对表【punishment(处分表)】的数据库操作Service实现
* @createDate 2024-06-05 20:38:45
*/
@Service
public class PunishmentServiceImpl extends ServiceImpl<PunishmentMapper, Punishment>
    implements PunishmentService{

}




