package com.soft1851.evaluation.util;

import java.util.Random;

/**
 * @Author: zw_w
 * @Date: 2020/6/3 13:08
 * @Description:
 */
public class StringUtil {
    public static String getVerifyCode(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(10)));
        }
        return stringBuilder.toString();
    }
}