package com.zhaolg5.singleton.userinfo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zhaolg5.singleton.userinfo.dto.AddressRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lingang.zhao
 * @version 1.0
 * @date 2019/10/1 4:22 下午
 */
@Component
@Slf4j
public class IpAddressUtils {

    @Resource
    private RestTemplate restTemplate;

    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public AddressRespDto getAddress(String ip) {
        AddressRespDto responseDto = null;
        try {
            String rtn = restTemplate.getForObject("http://ip.taobao.com/service/getIpInfo.php?ip=={ip}", String.class, ip);
            if (StringUtils.isEmpty(rtn)) {
                return null;
            }
            responseDto = GSON.fromJson(rtn, new TypeToken<AddressRespDto>() {
            }.getType());
        } catch (Exception e) {
            log.error("IpAddressUtils getAddress is failed , errMsg={}", e.getMessage(), e);
        }
        return responseDto;
    }

}
