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

import id.co.pussenif.dao.GolonganDAO;
import id.co.pussenif.model.Golongan;

@Controller
@RequestMapping("golongan")
public class GolonganController {
	
	@Autowired
	private GolonganDAO golonganDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaGolongan", golonganDAO.getAllGolongan());
		return "golongan/index";
	}
	
	@GetMapping("/detail/{golonganId}")
	public String detail(Model model, @PathVariable("golonganId")short id) {
		model.addAttribute("objekGolongan", golonganDAO.getGolongan(id));
				
		
		return "golongan/detail";	
	}
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("golongan", new Golongan());
		return "golongan/add";
	}
	
	@PostMapping("/add")
	public String addGolongan(Golongan golongan, BindingResult result){
		if(!result.hasErrors() && golonganDAO.addGolongan(golongan)) {
			return "redirect:/golongan/index";
		}else {
			
			return "golongan/add";
		}
	}
	
	@GetMapping("/edit/{golonganId}")
	public String editForm(Model model, @PathVariable("golonganId") short id) {
		model.addAttribute("golongan", golonganDAO.getGolongan(id));	
		return "golongan/edit";	
	}
	
	@PostMapping("/golongan")
	public String editGolongan(@Valid Golongan golongan, BindingResult result){
		if(!result.hasErrors() && golonganDAO.editGolongan(golongan)) {
			return "redirect:/golongan/index";
		}else {
			
			return "golongan/edit/";
		}
	}
}
