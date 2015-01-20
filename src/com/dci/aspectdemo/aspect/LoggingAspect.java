package com.dci.aspectdemo.aspect;

import com.dci.aspectdemo.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by ltornquist on 1/20/2015.
 */
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		//Circle circle = (Circle) joinPoint.getTarget();

		//System.out.println(joinPoint.getTarget().toString());
		//System.out.println("Advice run. Get Method called");
	}

	@Before("args(argument)")
	public void stringArgumentMethods(String argument)
	{
		System.out.println("A method that takes String arguments has been called: " + argument);
	}

	@Pointcut("execution(* get*())")
	public void allGetters(){}

	//@Pointcut("execution(* com.dci.aspectdemo.model.Circle.*(..))")
	@Pointcut("within(com.dci.aspectdemo.model.Circle)")
	public void allCircleMethods(){}


}
