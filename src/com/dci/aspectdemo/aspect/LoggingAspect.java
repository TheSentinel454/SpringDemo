package com.dci.aspectdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by ltornquist on 1/20/2015.
 */
@Aspect
public class LoggingAspect {

	@Before("execution(public String getName())")
	public void LoggingAdvice()
	{
		System.out.println("Advice run. Get Method called");
	}
}
