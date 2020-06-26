package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.ModuleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: zw_w
 * @Date: 2020/6/22 10:26
 * @Description:
 */
public interface ModuleTypeRepository extends JpaRepository<ModuleType,Integer> {
    /**
     * 更新module_type的module_id1
     * @param moduleId
     * @return
     */
    @Query("update ModuleType m set m.moduleId = ?1")
    int updateModuleId1(Integer moduleId);
}
