package com.student.controller;

import com.student.common.R;
import com.student.domain.bo.StudentBo;
import com.student.domain.vo.StudentVo;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询学生列表
     * @param bo 查询条件
     * @return 学生列表
     */
    @GetMapping
    public R<List<StudentVo>> getStudentList(StudentBo bo) {
        List<StudentVo> list = studentService.getStudentVoList(bo);
        return R.ok(list);
    }

}
