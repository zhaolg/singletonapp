package com.zhaolg5.singleton.userinfo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author lingang.zhao
 * @date 2019/10/1 3:36 下午
 * @version 1.0
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {

    /**
     * 两个..代表所有子目录，最后括号里的两个..代表所有参数
     */
    @Pointcut("execution(public * com.zhaolg5.singleton..controller.*.*(..)) && !execution(public * com.zhaolg5.singleton..controller.*.health(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("[{}],[{}],[{}],[{}]", request.getRemoteAddr(), request.getMethod(), request.getRequestURL(),
                Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * returning的值和doAfterReturning的参数名一致
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // ob 为方法的返回值
        Object ob = pjp.proceed();

        log.info("cost : " + (System.currentTimeMillis() - startTime));
        return ob;
    }


}
