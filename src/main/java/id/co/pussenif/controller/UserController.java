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

import id.co.pussenif.dao.UserDAO;
import id.co.pussenif.model.User;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaUser", userDAO.getAllUser());
		return "user/index";
	}
	
	@GetMapping("/detail/{userId}")
	public String detail(Model model, @PathVariable("userId")short id) {
		model.addAttribute("objekUser", userDAO.getUser(id));
				
		
		return "user/detail";	
	}
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "user/add";
	}
	
	@PostMapping("/add")
	public String addUser(User user, BindingResult result){
		if(!result.hasErrors() && userDAO.addUser(user)) {
			return "redirect:/user/index";
		}else {
			
			return "user/add";
		}
	}
	
	@GetMapping("/edit/{userId}")
	public String editForm(Model model, @PathVariable("userId") short id) {
		model.addAttribute("user", userDAO.getUser(id));	
		return "user/edit";	
	}
	
	@PostMapping("/edit")
	public String editUser(@Valid User user, BindingResult result){
		if(!result.hasErrors() && userDAO.editUser(user)) {
			return "redirect:/user/index";
		}else {
			
			return "user/edit/";
		}
	}

}
