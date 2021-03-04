package com.spring.biz.common;

public class AfterAdvice {
	public void afterLog() {
		System.out.println("[ 후처리 - AfterAdvice.afterLog()]"
					 + "비지니스 로직 수행후 로그(언제나, 무조건 실행)");
	}
}
