package com.student.controller;

import com.student.common.BaseEntity;
import com.student.common.R;
import com.student.domain.entity.Punishment;
import com.student.domain.entity.StudentPunishment;
import com.student.service.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/punishment")
public class PunishmentController {

    @Autowired
    private PunishmentService punishmentService;

    /**
     * 查询处分记录
     * @param studentId 学生id
     * @return 处分记录集合
     */
    @GetMapping
    public R<List<Punishment>> list(Long studentId) {
        List<Punishment> list = punishmentService.lambdaQuery()
                .eq(studentId != null, Punishment::getId, studentId)
                .orderByDesc(BaseEntity::getCreateTime)
                .list();
        return R.ok(list);
    }

    /**
     * 添加处分记录
     * @param sp 处分集合
     */
    @PostMapping
    public R<Void> add(List<StudentPunishment> sp) {
        punishmentService.saveList(sp);
        return R.ok();
    }

    /**
     * 删除处分记录
     * @param id 处分id
     */
    @DeleteMapping
    public R<Void> delete(Long id) {
        punishmentService.removeId(id);
        return R.ok();
    }

}
