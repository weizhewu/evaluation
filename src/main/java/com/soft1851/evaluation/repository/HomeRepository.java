package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 11:09
 * @Description:
 */
public interface HomeRepository extends JpaRepository<Home,Integer> {
    /**
     * 根据id查询home
     * @param homeId 主键
     * @return Home
     */
    @Query(value="select * from home where home_id = ?1", nativeQuery = true)
    Home getByHomeId(Integer homeId);
}
