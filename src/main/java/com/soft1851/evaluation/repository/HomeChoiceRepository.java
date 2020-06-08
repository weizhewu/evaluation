package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.HomeChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 13:01
 * @Description:
 */
public interface HomeChoiceRepository extends JpaRepository<HomeChoice,Integer> {
    /**
     * 根据选项id查询得分
     * @param choiceId int
     * @return int
     */
    @Query(value="select * from home_choice where home_choice_id = ?1", nativeQuery = true)
    int getCodeByHomeChoiceId(Integer choiceId);
}
