package br.com.ifsp.codelab.Codelab.controllers;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifsp.codelab.Codelab.dto.RequisicaoNovoProfessor;
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
	public ModelAndView nnew(RequisicaoNovoProfessor requisicao)
	{
		ModelAndView mav = new ModelAndView("professores/new");
		mav.addObject("listaStatusProfessor", StatusProfessor.values());
		
		return mav;
	}
	
	@PostMapping("/professores")
	public ModelAndView create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult) 
	{
        if (bindingResult.hasErrors()) 
        {
            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        }
        else 
        {
            Professor professor = requisicao.toProfessor();
            this.professorRepository.save(professor);

            return new ModelAndView("redirect:/professores/");
        }
    }
}
