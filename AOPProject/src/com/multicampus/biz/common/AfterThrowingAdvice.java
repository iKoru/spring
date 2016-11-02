package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service("afterThrowing")
@Aspect
public class AfterThrowingAdvice {

	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] "+ method +"() ���� �� ���� �߻� : "+exceptionObj.getMessage());
	}
}
