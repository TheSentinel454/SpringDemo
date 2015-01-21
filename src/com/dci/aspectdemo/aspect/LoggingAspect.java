package com.dci.aspectdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;

/**
 * Created by ltornquist on 1/20/2015.
 */
public class LoggingAspect {

	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		Object returnValue = null;
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable throwable) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}

	public void loggingAdvice()
	{
		System.out.println("Logging from the advice!");
	}
}
