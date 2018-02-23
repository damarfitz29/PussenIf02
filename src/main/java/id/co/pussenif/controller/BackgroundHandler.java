package id.co.pussenif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.pussenif.dao.DivisiDAO;
import id.co.pussenif.dao.GolonganDAO;
import id.co.pussenif.dao.SubDivDAO;
import id.co.pussenif.dao.UserDAO;
import id.co.pussenif.model.Golongan;
import id.co.pussenif.model.Subdivisi;
import id.co.pussenif.model.User;

@RestController
public class BackgroundHandler {
	
	@Autowired
	private GolonganDAO golonganDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private DivisiDAO divisiDAO;
	@Autowired
	private SubDivDAO subdivDAO;
	
	@GetMapping("/gantiNamaGol")
	public boolean gantiNamaGol(
			@RequestParam("x") short Id,
			@RequestParam("y") String Nama) {
			
		Golongan updatedGolongan = golonganDAO.getGolongan(Id);
		updatedGolongan.setNama(Nama);
		return golonganDAO.editGolongan(updatedGolongan);
	}
	
	@GetMapping("/deleteUser")
	public boolean deleteUser(
			@RequestParam("userId") short id){
				
		User user = userDAO.getUser(id);
		user.setIsActive(1);
		return userDAO.editUser(user);
	}
	
	@GetMapping("/deleteGol")
	public boolean deleteGol(
			@RequestParam("golonganId") short id){
				
		Golongan gol = golonganDAO.getGolongan(id);
		gol.setIsActive(1);
		return golonganDAO.editGolongan(gol);
	}
	
	@GetMapping("/deleteSub")
	public boolean deleteSub(
			@RequestParam("subdivId") short id) {
		
		Subdivisi subdiv = subdivDAO.getSubdivisi(id);
		subdiv.setIsActive(1);
		return subdivDAO.editSubdivisi(subdiv);
	}
	
	@GetMapping("/tampilSubdiv")
	public boolean tampilSubdiv(
			@RequestParam("subdivId") short id){
		
		Subdivisi sd = subdivDAO.getSubdivisi(id);
		sd.getSubdivId();
		return subdivDAO.addSubdivisi(sd);
	}
	
}
