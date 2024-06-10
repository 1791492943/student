package com.student.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.student.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学生处分关联表
 * @TableName student_punishment
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="student_punishment")
@Data
public class StudentPunishment extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 处分等级 (前端传输时)
     */
    private Integer punishmentLevel;

    /**
     * 1表示通报批评
     */
    private Integer criticism;

//    /**
//     * 第几次通报批评
//     */
//    @TableField(exist = false)
//    private Integer criticismNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 当前年份
     */
    @TableField(value = "`year`")
    private Integer year;

    /**
     * 学期
     */
    private Integer semester;

    /**
     * 处分时间
     */
    private Date punishmentTime;

    /**
     * 变化(up down noChange)
     */
    @TableField(value = "`change`")
    private String change;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}