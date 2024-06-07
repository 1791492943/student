package com.student.domain.bo;

import lombok.Data;

@Data
public class StudentBo {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学号
     */
    private String studentCode;

    /**
     * 班级id
     */
    private Integer classId;

    /**
     * 处分等级
     */
    private Integer level;


}
