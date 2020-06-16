package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: zw_w
 * @Date: 2020/6/16 10:00
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value="select * from user where phone = ?1", nativeQuery = true)
    User findByPhone(String phone);
}
