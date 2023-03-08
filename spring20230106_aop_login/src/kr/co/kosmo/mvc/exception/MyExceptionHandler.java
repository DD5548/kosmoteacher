package kr.co.kosmo.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
public class MyExceptionHandler {
	// ��� ����
	@ExceptionHandler(Exception.class)
	public String myHandlerException(Model model, Exception e) {
		e.printStackTrace();
		System.out.println("���� �޽���: "+e.getMessage());
		
		String viewName = null;
		
		// �Ķ��Ÿ�� ���� �� @RequestParam üũ�Ǿ
		// MissingServletRequestParameterException: Required String parameter 'id' is not present
		if(e instanceof MissingServletRequestParameterException) {
			model.addAttribute("emsg", "�Ķ��Ÿ ���� �ùٸ��� �ۼ��Ͻÿ�.");
			viewName = "error/paramException";
		} else if(e instanceof UnsatisfiedServletRequestParameterException) {
			model.addAttribute("emsg", "�Ķ��Ÿ ���� �ùٸ��� �ۼ��Ͻÿ�.2");
			viewName = "error/paramException";
		} else {
			model.addAttribute("emsg", "���ܰ� �߻��ϳ���?");
			viewName = "error/paramException";
		}
		
		return viewName;
	}
}
