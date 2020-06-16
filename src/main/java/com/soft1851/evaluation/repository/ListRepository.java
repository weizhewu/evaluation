package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 9:03
 * @Description:
 */
public interface ListRepository extends JpaRepository<List,Integer> {
    /**
     * 首页展示20条数据
     * @return
     */
    @Query(value="select * from list where type = 0 limit 0,20", nativeQuery = true)
    java.util.List<List> findHome();
    /**
     * 首页展示20条数据,模糊查询
     * @return
     */
    @Query(value="select l from List l where l.type = 0 and l.title like %?1% ")
    java.util.List<List> findHomeByKeywords(String keywords);

    /**
     * 疫情防控模块100条数据
     * @return
     */
    @Query(value="select * from list where type = 1 limit 0,100", nativeQuery = true)
    java.util.List<List> findSpecial();

    /**
     * 根据title模糊查询
     * @param title
     * @return
     */
    @Query(value = "select l from List l where l.title like %?1%")
    java.util.List<List> findByTitle(String title);

    /**
     * 根据id查询list
     * @param id
     * @return
     */
    @Query(value="select * from list where list_id = ?1", nativeQuery = true)
    List findByList_id(Integer id);
}
