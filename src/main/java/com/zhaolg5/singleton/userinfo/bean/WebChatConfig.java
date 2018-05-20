package com.zhaolg5.singleton.userinfo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhaolg on 2018/5/18
 *
 * @return
 * @throws Exception
 */
@Component
public class WebChatConfig {

    @Value("${weixin.appId}")
    private String appId;

    @Value("${weixin.secret}")
    private String secret;

    @Value("${weixin.api.url}")
    private String webChaturl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getWebChaturl() {
        return webChaturl;
    }

    public void setWebChaturl(String webChaturl) {
        this.webChaturl = webChaturl;
    }
}
