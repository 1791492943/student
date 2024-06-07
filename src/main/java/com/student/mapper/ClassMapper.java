package com.student.mapper;

import com.student.domain.entity.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 17914
* @description 针对表【class(班级表)】的数据库操作Mapper
* @createDate 2024-06-05 20:38:45
* @Entity com.student.domain.entity.Class
*/
@Mapper
public interface ClassMapper extends BaseMapper<Class> {

}




