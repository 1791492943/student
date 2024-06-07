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
 * 学生班级关联表
 * @TableName student_class
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="student_class")
@Data
public class StudentClass extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 学生id
     */
    private Long studentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}