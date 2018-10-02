package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterRequestValidator implements Validator{
	
	//JS에서 alert 를 사용하는것 대신 
	private static final String emailRegExp ="^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@" 
					+ "[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)" + "*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);	//패턴 초기화후 emailRegExp 를 패턴으로하기
	}
	
	
	public boolean supports(Class<?> clazz) {
	       return RegisterRequestValidator.class.isAssignableFrom(clazz);
	    }
	
	
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target; 
		//target 은 object타입이므로 형변환 object는 최상위 객체이기 때문에 모든객체를 저장할수 있지만 그 반대는 불가능하므로 형변환.
		if (regReq.getEmail()==null || regReq.getEmail().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			errors.rejectValue("email","bad");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
	
	
}
