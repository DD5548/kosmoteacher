package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestController {

	@GetMapping("/test111")
	public String test() {
		return "test";
	}
}
