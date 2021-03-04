package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
//	public void beforeLog() {
//		System.out.println("[사전처리 - BeforeAdvice.beforeLog]"
//					+ " 비지니스 로직 수행전 로그");
//	}
	
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); // 실행될 메소드 명
		Object[] args = jp.getArgs();	// object 타입의 인자들
		System.out.println("args : " + Arrays.toString(args));
		
		System.out.println("[사전처리] " + methodName + "() 메소드" 
				 + ", args 정보 : " + args[0] + " - 비지니스 로직 수행전 로그");
	}
}
