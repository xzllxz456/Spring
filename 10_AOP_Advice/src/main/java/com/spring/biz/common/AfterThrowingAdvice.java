package com.spring.biz.common;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[ 후처리 - AfterThrowingAdvice.exceptionLog()]"
					+ " 비지니스 로직 수행중 예외 발생시 로그");
	}
}
