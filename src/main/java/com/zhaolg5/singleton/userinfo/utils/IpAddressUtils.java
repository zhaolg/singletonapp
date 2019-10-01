package com.zhaolg5.singleton.userinfo.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lingang.zhao
 * @version 1.0
 * @date 2019/10/1 4:22 下午
 */
@Component
public class IpAddressUtils {

    @Resource
    private RestTemplate restTemplate;

    public String getAddress(String ip) {
        return restTemplate.getForObject("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip={ip}", String.class, ip);
    }

}
