package com.soft1851.evaluation.domain.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 常量配置类
 * @author wzw
 */

@Configuration
@Data
public class Constants {

    @Value("101513767")
    private String qqAppId;

    @Value("b1d978cefcf405388893d8e686d307b0")
    private String qqAppSecret;

    @Value("http://127.0.0.1:8080/QQLogin")
    private String qqRedirectUrl;

//    @Value("${constants.weCatAppId}")
//    private String weCatAppId;
//
//    @Value("${constants.weCatAppSecret}")
//    private String weCatAppSecret;
//
//    @Value("${constants.weCatRedirectUrl}")
//    private String weCatRedirectUrl;
}