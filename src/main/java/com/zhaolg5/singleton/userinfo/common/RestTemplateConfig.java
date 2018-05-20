package com.zhaolg5.singleton.userinfo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaolg on 2018/5/19
 *
 * @return
 * @throws Exception
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 超时时间
     */
    private static final int connectTimeout = 1000;

    private static final int readTimeout = 1000;

    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        return new RestTemplate(requestFactory);
    }

}
