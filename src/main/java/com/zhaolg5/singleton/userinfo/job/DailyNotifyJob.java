package com.zhaolg5.singleton.userinfo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author lingang.zhao
 * @version 1.0
 * @date 2019/9/30 4:56 下午
 */
@Component
@Slf4j
public class DailyNotifyJob {

    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    private static final String defVal = "1";

    private static final String KEY_JOB = "singleton.job";

    @Scheduled(cron = "0/30 * *  * * ? ")
    public void execute() {

        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                log.error("curr " + 1);
                stringRedisTemplate.opsForValue().increment(KEY_JOB, 1);
                return "1";
            }
        });

        new Thread(futureTask).start();

        try {
            String val = (String) futureTask.get();
            if (defVal.equals(val)) {
                log.error("success");
            }
        } catch (Exception e) {
            log.error("futureTask error,msg={}", e.getMessage(), e);
        }

    }

}
