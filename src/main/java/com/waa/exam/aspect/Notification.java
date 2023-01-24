package com.waa.exam.aspect;

import com.waa.exam.service.Impl.AddressServiceImpl;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Notification {
    private AddressServiceImpl service;
    public Notification(AddressServiceImpl service){
        this.service = service;
    }
    @Pointcut("@annotation(com.waa.exam.aspect.annotation.Alert)")
    public void send1(){
    }

    @Pointcut("execution(public void com.waa.exam.controller.AddressController.getById(Integer,..))")
    public void send2(){
    }

    @Pointcut("target(com.waa.exam.controller.AddressController)")
    public void send3(){
    }

    @Pointcut("within(com.waa.exam.controller.AddressController.*)")
    public void send4(){
    }

    @Before(value = "send1()")
    public void send1AlertBefore(JoinPoint joinpoint ){
        System.out.println("Send1 Before");
    }
    @Before(value = "send2()")
    public void send2AlertBefore(JoinPoint joinpoint ){
        System.out.println("Send2 Before");
    }
    @Before(value = "send3()")
    public void send3AlertBefore(JoinPoint joinpoint ){
        System.out.println("Send3 Before");
    }
    @Before(value = "send4() && args(Integer,..)")
    public void send4AlertBefore(JoinPoint joinpoint ){
        System.out.println("Send4 Before");
    }

//    @AfterReturning(value = "send2()")
//    public void sendAlertAfter(JoinPoint joinpoint ){
//        System.out.println("Send2 AfterReturning");
//    }

    @Pointcut("execution(* com.waa.exam.controller.AddressController.*(..))")
    public void log(){
        System.out.println("LOG Pointcut");
    }

    @AfterThrowing(value = "log()", throwing = "exception")
    public void sendAfterThrowing(JoinPoint joinpoint, Exception exception) throws Throwable{
        System.out.println("Logging AfterThrowing");
    }
}
