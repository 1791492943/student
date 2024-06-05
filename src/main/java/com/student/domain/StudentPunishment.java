package com.student.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生处分关联表
 * @TableName student_punishment
 */
@TableName(value ="student_punishment")
@Data
public class StudentPunishment implements Serializable {
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
     * 处分id
     */
    private Long punishmentLevel;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}