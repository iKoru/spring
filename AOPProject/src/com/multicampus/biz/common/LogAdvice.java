package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service("log")
@Aspect
public class LogAdvice {
	@Before("PointcutCommon.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] "+method + "() 메소드 args 정보 : "+ args[0].toString());
	}
}
