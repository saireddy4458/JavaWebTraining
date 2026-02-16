package com.ibm.springboot.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//								return type 					classes 	methods parameters exceptions
	@Pointcut("execution(public * com.ibm.springboot.services.*.*(..) )")
//	Defines a pointcut that matches the execution of any methods in classes under com.ibm.springboot.services packages
	public void allServiceMethods() {

	}
	
	@Before("allServiceMethods()")
//	advice that runs before the execution of methods matched by the joinpoint, regardless of their outcome 
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("------------ Before method:"+joinPoint.getSignature().getName());
		System.out.println("------------ Before method:"+joinPoint.getSignature());
	}
	
	@After("allServiceMethods()")
//	advice that runs after the execution of methods matched by the joinpoint, regardless of their outcome 
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("------------ After method:"+joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut="allServiceMethods()", returning="result")
//	advice that runs if a method matched by the joinpoint returns successfully
	public void logAfterRunning(JoinPoint joinPoint, Object result) {
		System.out.println("------------ Method returned :"+result);
	}
	
	@AfterThrowing(pointcut="allServiceMethods()", throwing="error")
//	advice that runs if a method matched by the joinpoint throws an exception
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error ) {
		System.out.println("Method threw exception:"+error);
	}
	
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Before and after method: "+joinPoint.getSignature().getName());
		return joinPoint.proceed();
//		Proceed with the next advice or target method invocation
	}
	
}
