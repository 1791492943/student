package com.student.domain.vo;

import com.student.domain.entity.Class;
import com.student.domain.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentVo {

    private Student student;
    private List<Class> classList;

}
