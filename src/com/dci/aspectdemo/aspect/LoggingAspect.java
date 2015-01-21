package com.dci.aspectdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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

	@AfterReturning(pointcut = "args(argument)", returning = "returnString")
	public void stringArgumentMethods(String argument, Object returnString)
	{
		System.out.println("A method that takes String arguments has been called.");
		System.out.println("Value: " + argument + " Output: " + returnString);
	}

	@AfterThrowing(pointcut = "args(argument)", throwing = "ex")
	public void exceptionAdvice(String argument, Exception ex)
	{
		System.out.println("An exception has been thrown.");
		System.out.println("Arg: " + argument + " Exception: " + ex);
	}

	@Around("@annotation(com.dci.aspectdemo.aspect.Loggable)")
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

	@Pointcut("execution(* get*())")
	public void allGetters(){}

	//@Pointcut("execution(* com.dci.aspectdemo.service.*Service.*(..))")
	//public void allServices(){}

	//@Pointcut("execution(* com.dci.aspectdemo.model.Circle.*(..))")
	@Pointcut("within(com.dci.aspectdemo.model.Circle)")
	public void allCircleMethods(){}


}
