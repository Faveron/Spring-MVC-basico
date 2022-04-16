package br.com.ifsp.codelab.Codelab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifsp.codelab.Codelab.models.Professor;
import br.com.ifsp.codelab.Codelab.models.StatusProfessor;
import br.com.ifsp.codelab.Codelab.repositories.ProfessorRepository;

@Controller
public class Professorcontroller 
{
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping("/professores")
	public ModelAndView index() 
	{
		List<Professor> professores = this.professorRepository.findAll();		
		ModelAndView mav = new ModelAndView("professores/index");
		mav.addObject("professores", professores);
		
		return mav;
	}
	
	
	@GetMapping("/professores/new")
	public ModelAndView nnew()
	{
		ModelAndView mav = new ModelAndView("professores/new");
		mav.addObject("statusProfessor", StatusProfessor.values());
		
		return mav;
	}
}
