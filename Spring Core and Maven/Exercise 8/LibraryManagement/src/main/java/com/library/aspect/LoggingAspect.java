package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..)) || execution(* com.library.repository.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[Aspect Log - Before] Starting execution of: " + joinPoint.getSignature().toShortString());
    }

    @After("execution(* com.library.service.*.*(..)) || execution(* com.library.repository.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[Aspect Log - After] Finished execution of: " + joinPoint.getSignature().toShortString());
    }
}
