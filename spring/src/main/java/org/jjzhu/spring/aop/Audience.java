package org.jjzhu.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by hzzhujiajun on 2017/7/7.
 */
@Aspect
public class Audience {
    @Pointcut("execution(* org.jjzhu.spring.aop.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("taking seats");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            silenceCellPhones();
            takeSeats();
            jp.proceed();
            applause();
        }catch (Throwable e){
            demandRefund();
        }
    }



}
