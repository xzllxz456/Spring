package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 객체 (인스턴스) 생성
@Aspect	 // 포인트 컷 + 어드바이스 연결
public class BeforeAdvice {
//	public void beforeLog() {
//		System.out.println("[사전처리 - BeforeAdvice.beforeLog]"
//					+ " 비지니스 로직 수행전 로그");
//	}
	
	// 포인트컷 작성 : 명칭은 메소드명 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {	}
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); // 실행될 메소드 명
		Object[] args = jp.getArgs();	// object 타입의 인자들
		System.out.println("args : " + Arrays.toString(args));
		
		if(args == null || args.length < 1) {
			System.out.println("[사전처리] " + methodName + "() 메소드" 
					+ ", args 정보 : 없음 - 비지니스 로직 수행전 로그");
		} else {
			System.out.println("[사전처리] " + methodName + "() 메소드" 
					+ ", args 정보 : " + args[0] + " - 비지니스 로직 수행전 로그");
		}
	}
}
