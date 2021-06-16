package com.ssm.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//定义切点类
@Aspect
@Component
public class MyAspect {
	//定义切点表达式
	@Pointcut("execution(* com.ssm.aspectj.*.*(..))")
	//使用一个返回值为void，方法体为空的方法来命名切点
	public void myPointCut() {}
	
	//前置通知
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("前置通知，模拟执行权限检查...");
		System.out.print("目标类是："+joinPoint.getTarget());
		System.out.println("被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
		
	}
	
	//后置通知
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("后置通知，模拟记录日志...");
		System.out.println("被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
	}
	
	/**
	 * 环绕通知
	 * ProceedingJoinPoint是JoinPoint的子接口，表示可执行目标方法
	 * 1.必须是object类型的返回值
	 * 2.必须接收一个参数，类型为ProceedingJoinPoint
	 * 3.必须是throws Throwable
	 * */
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//开始
		System.out.println("环绕开始：执行目标方法前，模拟开启事物...");
		//执行当前目标方法
		Object obj = proceedingJoinPoint.proceed();
		//结束
		System.out.println("环绕结束：执行目标方法后，模拟关闭事物...");
		return obj;
	}
	
	@AfterThrowing(value="myPointCut()",throwing = "e")
	//异常通知
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("异常通知：出错了"+e.getMessage());
	}
	
	@After("myPointCut()")
	//最终通知
	public void myAfter() {
		System.out.println("最终通知：模拟方法结束后释放资源");
	}
	
}
