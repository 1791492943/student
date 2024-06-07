package com.student.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.student.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 班级表
 * @TableName class
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="class")
@Data
public class Class extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 年份
     */
    @TableField(value = "`year`")
    private Integer year;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}