package controller;

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

	public void setMemberRegisterService(
			MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@RequestMapping(value = "/register/step2", method = RequestMethod.POST)
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@RequestMapping(value = "/register/step2", method = RequestMethod.GET)
	public String handleStep2Get() {
		return "redirect:step1";
	}

	@RequestMapping(value = "/register/step3", method = RequestMethod.POST)
	public String handleStep3(RegisterRequest regReq,
			Errors errors) {
/*		RegisterRequestValidator rrv = 
				new RegisterRequestValidator();
		rrv.validate(regReq, errors);*/
		
		new RegisterRequestValidator().validate(
						regReq, errors);
		
		if(errors.hasErrors()) return "register/step2";
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (AlreadyExistingMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
}
