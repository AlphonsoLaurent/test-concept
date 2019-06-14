package mx.com.ultrasist.proof_of_concept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("/proof-of-concept/api/customer")
public class WebController {
	
    @GetMapping(value="/")
    public String homepage(ModelMap model){
    	model.put("name", "in28Minutes"); 
        return "index";
    }
}