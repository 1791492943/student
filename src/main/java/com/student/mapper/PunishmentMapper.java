package com.student.mapper;

import com.student.domain.entity.Punishment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 17914
* @description 针对表【punishment(处分表)】的数据库操作Mapper
* @createDate 2024-06-05 20:38:45
* @Entity com.student.domain.entity.Punishment
*/
@Mapper
public interface PunishmentMapper extends BaseMapper<Punishment> {

}




