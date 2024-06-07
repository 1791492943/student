package com.student.mapper;

import com.student.domain.bo.StudentBo;
import com.student.domain.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.domain.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 17914
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2024-06-05 20:38:45
* @Entity com.student.domain.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> getSutdent(StudentBo bo);
}




