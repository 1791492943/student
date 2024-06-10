package com.student.domain.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StudentPunishmentVo {

    /**
     * 学生id
     */
    private List<Long> studentIds;

    /**
     * 等级变化
     */
    private Integer change;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 学期
     */
    private Integer semester;

    /**
     * 1表示通报批评
     */
    private Integer criticism;

    /**
     * 备注
     */
    private String remark;

    /**
     * 处分时间
     */
    private Date punishmentTime;

}
