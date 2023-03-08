package kr.co.kosmo.mvc.controller.email;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mail")
public class EmailController {
	static final String emailfromRecipient = "majh5548@naver.com";
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@GetMapping(value = "/form")
	public String form() {
		return "mail/form";
	}
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ModelAndView send(HttpServletRequest request) {
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String recipient = request.getParameter("recipient");
		
		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo(recipient);
				mimeMsgHelperObj.setFrom(emailfromRecipient);
				mimeMsgHelperObj.setText(message);
				mimeMsgHelperObj.setSubject(subject);
			}
		});
		System.out.println("\n Mail 傈价 己傍 \n");
		
		ModelAndView mav = new ModelAndView("success", "messageObj", "Mail 傈价 己傍");
		
		return mav;
	}
}
