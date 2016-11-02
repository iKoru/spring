package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service("around")
@Aspect
public class AroundAdvice {

	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		System.out.println("---< before logic >---");
		
		obj = pjp.proceed();
		
		System.out.println("---< after logic  >---");
		return obj;
	}
}
