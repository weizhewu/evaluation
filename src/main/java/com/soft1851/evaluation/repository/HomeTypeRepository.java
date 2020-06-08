package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.HomeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 13:54
 * @Description:
 */
public interface HomeTypeRepository extends JpaRepository<HomeType,Integer> {
    /**
     * 根据homeId或homeTypeId查询
     * @param homeId
     * @param homeTypeId
     * @return
     */
    @Query(value="select * from home_type where home_id = ?1 or home_type_id = ?2", nativeQuery = true)
    List<HomeType> getHomeTypeByHomeIdOrHomeTypeId(Integer homeId, Integer homeTypeId);
}
