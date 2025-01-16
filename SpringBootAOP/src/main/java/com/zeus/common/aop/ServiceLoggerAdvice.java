package com.zeus.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ServiceLoggerAdvice
{
	// com.zeus.service.BoardService 클래스에 속한 임의의 메서드를 대상으로 한다.
	//				return / package name / (매개변수)
	// 포인트컷.
//	@Before("execution(* com.zeus.service.BoardService*.*(..))")
//	public void startLog(JoinPoint jp)
//	{
//		log.info("startLog");
//		log.info("ServiceLoggerAdvice.startLog jp.signature : " + jp.getSignature());
//		log.info("ServiceLoggerAdvice.startLog jp.args : " + Arrays.toString(jp.getArgs()));
//		log.info("===================================================================================");
//	}
	
	// @After는 Error발생이 없어도 무조건 실행됨.(try-catch구문의 finally와 같은 역할.)
	// @After("execution(* com.zeus.service.BoardService*.*(..))")
//	@AfterReturning(pointcut = "execution(* com.zeus.service.BoardService*.*(..))", returning = "result")
//	public void stopLog(JoinPoint jp, Object result)
//	{
//		log.info("ServiceLoggerAdvice.stopLog");
//		if (result != null)
//		{
//			log.info("ServiceLoggerAdvice.stopLog result" + result.toString());
//		}
//		log.info("===================================================================================");
//	}
	
	// '핵심코드'에서 예외 발생 시 작동.
	@AfterThrowing(pointcut = "execution(* com.zeus.service.BoardService*.*(..))", throwing = "e")
	public void exceptionLog(JoinPoint jp, Exception e)
	{
		log.info("ServiceLoggerAdvice.exceptionLog");
		if (e != null)
		{
			log.info("ServiceLoggerAdvice.exceptionLog Exception" + e.toString());
		}
		log.info("===================================================================================");
	}
	
	// 조인포인트(핵심코드) 전, 후로 사용.
	@Around("execution(* com.zeus.service.BoardService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		
		long stopTime = System.currentTimeMillis();
		log.info(pjp.getSignature().getName() + " : " + (stopTime-startTime));
		log.info("===================================================================================");
		
		return obj;
	}
}