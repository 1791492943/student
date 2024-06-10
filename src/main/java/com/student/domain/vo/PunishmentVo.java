package com.student.domain.vo;

import com.student.domain.entity.Class;
import com.student.domain.entity.Punishment;
import com.student.domain.entity.Student;
import com.student.domain.entity.StudentPunishment;
import lombok.Data;

import java.util.List;

@Data
public class PunishmentVo {

    private StudentPunishment studentPunishment;
    private Punishment punishment;
    private Student student;
    private List<Class> classList;

}
