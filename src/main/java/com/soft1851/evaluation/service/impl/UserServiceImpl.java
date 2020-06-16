package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.domain.model.User;
import com.soft1851.evaluation.repository.UserRepository;
import com.soft1851.evaluation.service.UserService;
import com.soft1851.evaluation.util.PhoneUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: zw_w
 * @Date: 2020/6/16 10:17
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Override
    public ResponseResult login(String phone) {
        User user = userRepository.findByPhone(phone);
        if (phone == null || phone.length() ==0){
            return ResponseResult.failure(ResultCode.PHONE_NULL);
        }
        if (!PhoneUtil.isPhoneLegal(phone)){
            return ResponseResult.failure(ResultCode.PHONE_NOT_LEGAL);
        }
        if (user == null){
            user.setPhone(phone);
            user.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            try {
                userRepository.save(user);
            } catch (Exception e){
                return ResponseResult.failure(ResultCode.USER_INSERT_FAIL,e.getMessage());
            }

        }
        return ResponseResult.success(user);
    }
}
