package kr.co.kosmo.mvc.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.LoginLogDTO;

@Aspect
@Component
public class LoginAdvice {
	private String userAgent;

	@Autowired
	private MemberDaoInter dao;

	@Around("execution(* kr.co.kosmo.mvc.controller.login.LoginController.log*(..))")
	public ModelAndView log(ProceedingJoinPoint jp) {
		System.out.println("����!");

		ModelAndView rpath = null;
		// �޽���� �̸��� �����ͼ� �α��ΰ� �α׾ƿ��� �����Ѵ�.
		String methodName = jp.getSignature().getName();
		System.out.println("methodName -> " + methodName);

		// JoinPoint�κ��� Ÿ�� ��ü�� �޽���� ���� �� �޾ƿ���.
		Object[] fd = jp.getArgs();

		for (Object e : fd) {
			System.out.println(e.getClass().getName());
		}
		if (methodName.equals("login")) {
			try {
				rpath = (ModelAndView) jp.proceed(); // login �޽�带 ȣ��!
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// getArgs: ���� id, request, DTO, userAgent - 4��
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			userAgent = (String) fd[3];
			String reip = ((HttpServletRequest) fd[1]).getRemoteAddr();

			System.out.println("agent -> " + userAgent);
			System.out.println("reip -> " + reip);
			System.out.println("uid -> " + uid);

			// Login ������ DB�� �����ϱ�.
			LoginLogDTO vo = new LoginLogDTO();

			vo.setIdn(uid);
			vo.setReip(reip);
			vo.setStatus("Login");
			vo.setUagent(userAgent);

			dao.insertLog(vo);
		} else if (methodName.equals("logout")) {
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			String reip = ((HttpServletRequest) fd[1]).getRemoteAddr();
			userAgent = (String) fd[2];

			// Logout ������ DB�� �����ϱ�.
			LoginLogDTO vo = new LoginLogDTO();
			
			vo.setIdn(uid);
			vo.setReip(reip);
			vo.setStatus("Logout");
			vo.setUagent(userAgent);

			dao.insertLog(vo);

			// getArgs: ����, request - 3��
			try {
				rpath = (ModelAndView) jp.proceed(); // logout �޽�带 ȣ��!
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("����2!");

		return rpath;
	}
}
