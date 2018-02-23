package id.co.pussenif.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.pussenif.dao.PresensiDAO;
import id.co.pussenif.model.Presensi;
import id.co.pussenif.model.User;

@Controller
@RequestMapping("presensi")
public class PresensiController {
	
	@Autowired
	private PresensiDAO presensiDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaPresensi", presensiDAO.getAllPresensi());
		return "presensi/index";
	}
	
	@GetMapping("/detail/{presensiId}")
	public String detail(Model model, @PathVariable("presensiId")short id) {
		model.addAttribute("objekPresensi", presensiDAO.getPresensi(id));
				
		
		return "presensi/detail";	
	}
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("presensi", new Presensi());
		return "presensi/add";
	}
	
	@PostMapping("/add")
	public String addPresensi(Presensi presensi, BindingResult result){
		if(!result.hasErrors() && presensiDAO.addPresensi(presensi)) {
			return "redirect:/presensi/index";
		}else {
			
			return "presensi/add";
		}
	}
}
