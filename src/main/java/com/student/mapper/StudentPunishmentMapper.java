package com.student.mapper;

import com.student.domain.entity.StudentPunishment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.domain.vo.PunishmentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 17914
* @description 针对表【student_punishment(学生处分关联表)】的数据库操作Mapper
* @createDate 2024-06-05 20:38:45
* @Entity com.student.domain.entity.StudentPunishment
*/
@Mapper
public interface StudentPunishmentMapper extends BaseMapper<StudentPunishment> {

}




