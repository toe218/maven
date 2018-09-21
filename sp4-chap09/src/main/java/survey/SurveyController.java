package survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import survey.AnswerData;

@RequestMapping("/survey")		//해당주소 survey 만 사용?
public class SurveyController {
	@RequestMapping(method=RequestMethod.GET)		//submit  get방식으로 처리
	public String form(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions",questions);
		return "survey/surveyForm";
		
	}
	private List<Question> createQuestions() {

				
		Question q1 = new Question("당신의 역할은 무엇입니까?",  Arrays.asList("서버","프론트","풀스택"));
		
		Question q2 = new Question("많이 사용하는 개발 도구는?", Arrays.asList("이클립스","인텔리J","서브라임"));
		
		Question q3 = new Question("하고싶은 말은");
		
		return Arrays.asList(q1,q2,q3);
		
		
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("ansData") AnswerData data) {
		
		return "survey/submitted";	//survey/submitted.jsp 로 전달
		
	}
	
	
}
