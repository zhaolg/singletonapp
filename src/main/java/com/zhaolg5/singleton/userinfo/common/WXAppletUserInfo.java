package com.zhaolg5.singleton.userinfo.common;

import com.zhaolg5.singleton.userinfo.bean.WebChatConfig;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import com.zhaolg5.singleton.userinfo.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * Created by zhaolg on 2018/5/19
 *
 * @return
 * @throws Exception
 */
@Configuration
public class WXAppletUserInfo {

    private static Logger log = LoggerFactory.getLogger(IUserInfoSV.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebChatConfig webChatConfig;

    public String getUserInfo(String code) throws Exception {
        String jsonStr = restTemplate.getForEntity(webChatConfig.getWebChaturl() + "?appid={0}&&secret={1}&js_code={2}&grant_type=authorization_code", String.class, webChatConfig.getAppId(), webChatConfig.getSecret(), code).getBody();
        Map<String, Object> stringObjectMap = BeanUtils.convertToMap(jsonStr);
        return (String) stringObjectMap.get("openid");
    }

}
