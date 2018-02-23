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

import id.co.pussenif.dao.DivisiDAO;
import id.co.pussenif.dao.SubDivDAO;
import id.co.pussenif.model.Divisi;
import id.co.pussenif.model.Golongan;
import id.co.pussenif.model.Subdivisi;

@Controller
@RequestMapping("divisi")
public class DivisiController {
	
	@Autowired
	private DivisiDAO divisiDAO;
	@Autowired
	private SubDivDAO subdivDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaDivisi", divisiDAO.getAllDivisi());
		return "divisi/index";
	}
	
	@GetMapping("/detail/{divisiId}")
	public String detail(Model model, @PathVariable("divisiId")short id) {
		model.addAttribute("objekDivisi", divisiDAO.getDivisi(id));
				
		
		return "divisi/detail";	
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("divisi", new Divisi());
		model.addAttribute("getSub", subdivDAO.getAllSubdivisi());
		return "divisi/add";
	}
	
	@PostMapping("/add")
	public String addDivisi(Divisi divisi, BindingResult result){
		if(!result.hasErrors() && divisiDAO.addDivisi(divisi)) {
			return "redirect:/divisi/index";
		}else {
			
			return "divisi/add";
		}
	}
	
	@GetMapping("/edit/{divisiId}")
	public String editForm(Model model, @PathVariable("divisiId") short id) {
		model.addAttribute("divisi", divisiDAO.getDivisi(id));	
		return "divisi/edit";	
	}
	
	@PostMapping("/edit")
	public String editDivisi(@Valid Divisi divisi, BindingResult result){
		if(!result.hasErrors() && divisiDAO.editDivisi(divisi)) {
			return "redirect:/divisi/index";
		}else {
			
			return "divisi/edit/";
		}
	}

}
