package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.ModuleChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: zw_w
 * @Date: 2020/6/22 10:30
 * @Description:
 */
public interface ModuleChoiceRepository extends JpaRepository<ModuleChoice,Integer> {
    /**
     * 更新module_choice的module_type_id1
     * @param moduleTypeId
     * @return
     */
    @Query("update ModuleChoice m set m.moduleTypeId = ?1")
    int updateModuleTypeId1(Integer moduleTypeId);
}
