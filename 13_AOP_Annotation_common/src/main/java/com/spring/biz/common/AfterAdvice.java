package com.spring.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// @Aspect, @Pointcut, @After 적용
// getPointCut

@Service
@Aspect
public class AfterAdvice {
	
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointCut() {
	}
	
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointCut() {
	}
	
	@After("allPointCut()")
	public void afterLog() {
		System.out.println("[ 후처리 - AfterAdvice.afterLog()]"
					 + "비지니스 로직 수행후 로그(언제나, 무조건 실행)");
	}
}
