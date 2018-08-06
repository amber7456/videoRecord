package com.webconfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import com.videorecord.bean.ResponseBean;
import com.videorecord.exception.ForegoneException;
import com.videorecord.util.Log4jFactory;

/**
 *  
 *  
 */
@SuppressWarnings("unused")
@Aspect
@Component
public class ServiceAspect {
	private final static Logger log = Log4jFactory.getLogger(ServiceAspect.class);

	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* com.videorecord.controller..*.*(..)) && execution(public com.videorecord.bean.ResponseBean *(..))")
	public void aspect() {
	}

	// 配置环绕通知,使用在方法aspect()上注册的切入点
	@Around("aspect()")
	public Object around(ProceedingJoinPoint joinPoint) {
		ResponseBean<?> result;
		try {
			result = (ResponseBean<?>) joinPoint.proceed();
		} catch (Throwable e) {
			result = handlerException(joinPoint, e);
		}
		//log.info(result.toString());
		return result;
	}

	private ResponseBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
		ResponseBean<String> result = new ResponseBean<String>();
		// 已知异常
		if (e instanceof ForegoneException) {
			result.setMsg(e.getLocalizedMessage());
			result.setCode(((ForegoneException) e).getErrcode());
			result.setData("");
		} else {
			// 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
			result.setMsg(e.toString());
			result.setCode(ResponseBean.FAIL);
			result.setData("");
		}
		log.info(result.toString());
		return result;
	}
	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点 同时接受JoinPoint切入点对象,可以没有该参数
	 */
	// @Before("aspect()")
	// public void before(JoinPoint joinPoint) {
	// System.out.println("执行before.....");
	// }

	// // 配置后置通知,使用在方法aspect()上注册的切入点
	// @After("aspect()")
	// public void after(JoinPoint joinPoint) {
	// System.out.println("执行after.....");
	// }

	// // 配置后置返回通知,使用在方法aspect()上注册的切入点
	// @AfterReturning("aspect()")
	// public void afterReturn(JoinPoint joinPoint) {
	// if (log.isInfoEnabled()) {
	// log.info("afterReturn " + joinPoint);
	// }
	// }

	// // 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	// @AfterThrowing(pointcut = "aspect()", throwing = "ex")
	// public void afterThrow(JoinPoint joinPoint, Exception ex) {
	// if (log.isInfoEnabled()) {
	// log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
	// }
	// }

}