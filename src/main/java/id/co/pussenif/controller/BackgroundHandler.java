package id.co.pussenif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.pussenif.dao.GolonganDAO;
import id.co.pussenif.model.Golongan;

@RestController
public class BackgroundHandler {
	
	@Autowired
	private GolonganDAO golonganDAO;
	
	@GetMapping("/gantiNamaGol")
	public boolean gantiNamaGol(
			@RequestParam("x") short Id,
			@RequestParam("y") String Nama) {
			
		Golongan updatedGolongan = golonganDAO.getGolongan(Id);
		updatedGolongan.setNama(Nama);
		return golonganDAO.editGolongan(updatedGolongan);
	}
	
}
