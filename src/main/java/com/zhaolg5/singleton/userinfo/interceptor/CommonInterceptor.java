package com.zhaolg5.singleton.userinfo.interceptor;

import com.zhaolg5.singleton.userinfo.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author lingang.zhao
 * @version 1.0
 * @date 2019/10/1 3:25 下午
 */
@Slf4j
@Service
public class CommonInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    private static final String UN_KNOWN = "unknown";

    private static final String CLIENT_IP_LIST = "client:ip:list";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userIp = getUserIp(request);
        stringRedisTemplate.opsForHash().put(CLIENT_IP_LIST, userIp, DateUtils.dateToStr(new Date()));
        return true;
    }

    /**
     * 获取用户IP
     */
    private static String getUserIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }


}
