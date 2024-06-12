package com.student.service;

import com.student.domain.entity.Punishment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.entity.StudentPunishment;
import com.student.domain.vo.PunishmentVo;
import com.student.domain.vo.StudentPunishmentVo;

import java.util.List;

/**
* @author 17914
* @description 针对表【punishment(处分表)】的数据库操作Service
* @createDate 2024-06-05 20:38:45
*/
public interface PunishmentService extends IService<Punishment> {

    void saveList(StudentPunishmentVo sp);

    void removeId(Long id);

    List<PunishmentVo> list(String studentCode);

}
