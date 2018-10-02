package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;



@Controller
public class RegisterController {
	private MemberRegisterService memberRegisterService;
	@Autowired
	public RegisterController(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	@RequestMapping("/register/step2")
	public String handleStep2(Model model,
				@RequestParam(value="agree",defaultValue="false")boolean agree) {
		if (agree=false) {
			return "register/step1";
		}
		model.addAttribute("registerRequest",new RegisterRequest());
		return "register/step2";
	}
	@RequestMapping(value="/register/step3" ,method=RequestMethod.POST)
	//반환형이 String인 이유: JSP파일을 포워드하기 위함?
	public String handleStep3(RegisterRequest regReq, Errors errors) {
		/*RegisterRequestValidator rrv = new RegisterRequestValidator(); 
		rrv.validate(regReq, errors);*/
		new RegisterRequestValidator().validate(regReq, errors);
		
		if (errors.hasErrors()) return "register/step2";
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch(AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			e.printStackTrace();
			return "register/step2";
		}
	}
//	@RequestMapping("/main")					//지우고 spring-controller.xml에서 별도 설정 가능
//	public String main(Model model) {
//		return "main";
//		
//	}
	
}
