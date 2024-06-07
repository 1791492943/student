package com.student.service;

import com.student.domain.entity.Punishment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.entity.StudentPunishment;

import java.util.List;

/**
* @author 17914
* @description 针对表【punishment(处分表)】的数据库操作Service
* @createDate 2024-06-05 20:38:45
*/
public interface PunishmentService extends IService<Punishment> {

    void saveList(List<StudentPunishment> sp);

    void removeId(Long id);
}
