package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zw_w
 * @Date: 2020/6/22 10:32
 * @Description:
 */
public interface ModuleRepository extends JpaRepository<Module,Integer> {
}
