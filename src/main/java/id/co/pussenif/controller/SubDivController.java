package id.co.pussenif.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.pussenif.dao.SubDivDAO;
import id.co.pussenif.model.Subdivisi;


@Controller
@RequestMapping("subdivisi")
public class SubDivController {
	@Autowired
	private SubDivDAO subdivDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaSubdivisi", subdivDAO.getAllSubdivisi());
		return "subdiv/index";
	}
	
	@GetMapping("/detail/{subdivId}")
	public String detail(Model model, @PathVariable("subdivId")short id) {
		model.addAttribute("objekSubdivisi", subdivDAO.getSubdivisi(id) );
				
		
		return "subdiv/detail";	
	}
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("subdivisi", new Subdivisi());
		return "subdiv/add";
	}
	
	@PostMapping("/add")
	public String addSubdivisi(Subdivisi subdivisi, BindingResult result){
		if(!result.hasErrors() && subdivDAO.addSubdivisi(subdivisi)) {
			return "redirect:/subdivisi/index";
		}else {
			
			return "subdiv/add";
		}
	}
	
	@GetMapping("/edit/{subdivId}")
	public String editForm(Model model, @PathVariable("subdivId") short id) {
		model.addAttribute("subdivisi", subdivDAO.getSubdivisi(id));	
		return "subdiv/edit";	
	}
	
	@PostMapping("/edit")
	public String editSubdivisi(@Valid Subdivisi subdivisi, BindingResult result){
		if(!result.hasErrors() && subdivDAO.editSubdivisi(subdivisi)) {
			return "redirect:/subdivisi/index";
		}else {
			
			return "subdiv/edit/";
		}
	}
}
