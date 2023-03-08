package kr.co.kosmo.mvc.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/*
 * 일반적인 bean으로 스칸 당해서 등록됨!
 */
@Component
@Aspect
public class TodayAdvice {
	// 공통 관심 사항이 무엇인가? -> 날짜
	// target? ->
	// 시점을 생각해볼 필요가 있다.
	@Before("execution(* kr.co.kosmo.mvc.controller.TodayMy*.today*(..))")
	public void todayBefore() {
		String todate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("-- Todate --");
		System.out.println(todate);
	}
	@AfterReturning(pointcut = "execution(* kr.co.kosmo.mvc.controller.Today*.today*(..))", returning = "mav")
	public ModelAndView afterToday(JoinPoint jp, ModelAndView mav) {
		// currentRequestAttributes() 사용해서 HttpServletRequest 받아서 사용자의 IP를 받아서 로깅해보기.
		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = ra.getRequest();
		mav.addObject("reip", request.getRemoteAddr());
		System.out.println("reip -> "+request.getRemoteAddr());
		mav.addObject("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		return mav;
	}
}
