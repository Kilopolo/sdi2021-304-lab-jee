package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Controller
public class ProfessorController {
	@Autowired // Inyectar el servicio
	private ProfessorService professorService;

	// AÑADIR

	@RequestMapping(value = "/prof/add", method = RequestMethod.GET)
	public String getProfessor(Model model) {
		model.addAttribute("professorsList", professorService.getProfessor());
		return "prof/add";
	}

	@RequestMapping(value = "/prof/add", method = RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor professor) {
		professorService.addProfessor(professor);
		return "redirect:/prof/list";
	}

	// EDITAR

	@RequestMapping(value = "/prof/edit/{id}", method = RequestMethod.GET)
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("prof", professorService.getProfessor(id));
		return "prof/edit";
	}

	@RequestMapping(value = "/prof/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Professor professor) {
		Professor original = professorService.getProfessor(id);
		// modificar solo score y description
		original.setDni(professor.getDni());
		original.setName(professor.getName());
		original.setLastName(professor.getLastName());
		original.setRole(professor.getRole());
		professorService.addProfessor(original);
		return "redirect:/prof/details/" + id;
	}

	// VER DETALLE

	@RequestMapping("/prof/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("mark", professorService.getProfessor(id));
		return "prof/details";
	}

	// BORRAR

	@RequestMapping(value = "/prof/delete/{id}", method = RequestMethod.GET)
	public String deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		return "redirect:/prof/list";
	}

}
