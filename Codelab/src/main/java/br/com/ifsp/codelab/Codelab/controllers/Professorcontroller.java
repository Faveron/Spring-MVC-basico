package br.com.ifsp.codelab.Codelab.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifsp.codelab.Codelab.models.Professor;
import br.com.ifsp.codelab.Codelab.models.StatusProfessor;

@Controller
public class Professorcontroller 
{
	@GetMapping("/professores")
	public ModelAndView index() 
	{
		Professor google = new Professor("Google", new BigDecimal(5000.0), StatusProfessor.ATIVO);
		google.setId(1L);
		Professor amazon = new Professor("Amazon", new BigDecimal(10000.0), StatusProfessor.APOSENTADO);
		amazon.setId(2L);
		List<Professor> professores = Arrays.asList(google, amazon);
		
		ModelAndView mav = new ModelAndView("professores/index");
		mav.addObject("professores", professores);
		
		return mav;
	}
}
