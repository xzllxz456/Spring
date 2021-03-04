package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
//	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//		// 핵심 메소드 실행전 처리
//		System.out.println("[ Around BEFORE - AroundAdvice.aroundLog() ]"
//				+ " 비지니스 로직 실행전 처리");
//		
//		Object returnobj =  pjp.proceed();	// 실행할 메소드 동작 시키기
//		
//		// 핵심 메소드 실행후 처리
//		System.out.println("[ Around AFTER - AroundAdvice.aroundLog() ]"
//				+ " 비지니스 로직 실행후 처리");
//		
//		return returnobj;
//	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("[ Around BEFORE - AroundAdvice.aroundLog() ]" + " 비지니스 로직 실행전 처리");
		Object returnobj = pjp.proceed(); // 실행할 메소드 동작 시키기
		System.out.println("[ Around AFTER - AroundAdvice.aroundLog() ]" + " 비지니스 로직 실행후 처리");
		
		stopWatch.stop();
		System.out.println("[around] " + methodName + "() 메소드 ** ,  " 
					+ "실행 시간 : " + stopWatch.getTotalTimeMillis() + " 초 (ms) ");
		return returnobj;
		
	}
}
