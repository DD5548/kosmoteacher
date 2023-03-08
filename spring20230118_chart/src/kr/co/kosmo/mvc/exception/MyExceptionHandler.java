package kr.co.kosmo.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
public class MyExceptionHandler {
	// 모든 예외
	@ExceptionHandler(Exception.class)
	public String myHandlerException(Model model, Exception e) {
		e.printStackTrace();
		System.out.println("예외 메시지: "+e.getMessage());
		
		String viewName = null;
		
		// 파라미타가 없을 때 @RequestParam 체크되어서
		// MissingServletRequestParameterException: Required String parameter 'id' is not present
		if(e instanceof MissingServletRequestParameterException) {
			model.addAttribute("emsg", "파라미타 값을 올바르게 작성하시오.");
			viewName = "error/paramException";
		} else if(e instanceof UnsatisfiedServletRequestParameterException) {
			model.addAttribute("emsg", "파라미타 값을 올바르게 작성하시오.2");
			viewName = "error/paramException";
		} else {
			model.addAttribute("emsg", "예외가 발생하나요?");
			viewName = "error/paramException";
		}
		
		return viewName;
	}
}
