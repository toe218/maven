import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
		@RequestMapping("/hello")
		public String hello(Model model,
					@RequestParam(value="name", required=false)String name) {		//Request ¥ÎΩ≈ MOdel
			model.addAttribute("greeting", "æ»≥Á«÷ø‰..."+name);
			return "hello";
		}	
}	
