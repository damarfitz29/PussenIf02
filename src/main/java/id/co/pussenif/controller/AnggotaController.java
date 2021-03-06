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

import id.co.pussenif.dao.AnggotaDAO;
import id.co.pussenif.dao.DivisiDAO;
import id.co.pussenif.dao.GolonganDAO;
import id.co.pussenif.model.Anggota;


@Controller
@RequestMapping("anggota")
public class AnggotaController {
	
	@Autowired
	private AnggotaDAO anggotaDAO;
	@Autowired
	private GolonganDAO golonganDAO;
	@Autowired
	private DivisiDAO divisiDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaAnggota", anggotaDAO.getAllAnggota());
		return "anggota/index";
	}
	
	@GetMapping("/detail/{anggotaId}")
	public String detail(Model model, @PathVariable("anggotaId")short id) {
		model.addAttribute("objekAnggota", anggotaDAO.getAnggota(id));
				
		
		return "anggota/detail";	
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("anggota", new Anggota());
		model.addAttribute("gol", golonganDAO.getAllGolongan());
		model.addAttribute("div", divisiDAO.getAllDivisi());
		return "anggota/add";
	}
	
	@PostMapping("/add")
	public String addAnggota(Anggota anggota, BindingResult result){
		if(!result.hasErrors() && anggotaDAO.addAnggota(anggota)) {
			return "redirect:/anggota/index";
		}else {
			
			return "anggota/add";
		}
	}
	
	@GetMapping("/edit/{anggotaId}")
	public String editForm(Model model, @PathVariable("anggotaId") short id) {
		model.addAttribute("anggota", anggotaDAO.getAnggota(id));	
		model.addAttribute("gol1", golonganDAO.getAllGolongan());
		model.addAttribute("div1", divisiDAO.getAllDivisi());
		return "anggota/edit";	
	}
	
	@PostMapping("/edit")
	public String editAnggota(@Valid Anggota anggota, BindingResult result){
		if(!result.hasErrors() && anggotaDAO.editAnggota(anggota)) {
			return "redirect:/anggota/index";
		}else {
			
			return "anggota/edit/";
		}
	}
}
