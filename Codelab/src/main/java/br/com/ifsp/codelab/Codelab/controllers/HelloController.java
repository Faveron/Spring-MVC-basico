package br.com.ifsp.codelab.Codelab.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class HelloController 
{
	@GetMapping("/hello")
    public ModelAndView hello() 
	{
        ModelAndView mav = new ModelAndView("hello");  
        mav.addObject("nome", "Almeida");
        return mav;
    }	

    @GetMapping("/hello-model")
    public String hello(Model model)
    {
    	model.addAttribute("nome", "Faveron");
    	return "hello";
    }
    
    @GetMapping("/hello-servlet")
    public String hello(HttpServletRequest request) 
    {
        request.setAttribute("nome", "Wesley");
        return "hello";
    }
}
