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
		// top advice
		long startTime = System.currentTimeMillis();
		
		
//		Object obj = null;
//		try
//		{
//			// BoardServiceImpl에 있는 모든 함수들이 작동.
//			// 오류를 발생하지 않으려면 모두 return값이 있어야 함. obj를 반환해야 하므로.
//			// 최소 return null;이라도 반환해야 함.
//			obj = pjp.proceed();
//		} catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
		
		
		
		
		// join point - 핵심코드 실행.
		Object obj = pjp.proceed();	// proceed는 객체를 줘야 함.
		
		// bottom advice
		long stopTime = System.currentTimeMillis();
		
		// etc info.
		log.info(pjp.getSignature().getName() + " : " + (stopTime-startTime));
		log.info("===================================================================================");
		
		return obj;
	}
}