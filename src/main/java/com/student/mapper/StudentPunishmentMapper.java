package com.student.mapper;

import com.student.domain.StudentPunishment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 17914
* @description 针对表【student_punishment(学生处分关联表)】的数据库操作Mapper
* @createDate 2024-06-05 20:38:45
* @Entity com.student.domain.StudentPunishment
*/
@Mapper
public interface StudentPunishmentMapper extends BaseMapper<StudentPunishment> {

}




