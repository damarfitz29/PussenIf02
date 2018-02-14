package id.co.pussenif.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.pussenif.model.Golongan;


@Service
public class GolonganDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Golongan> getAllGolongan(){
		return factory.createEntityManager()
				.createQuery("from Golongan")
				.getResultList();
	}
	
	public Golongan getGolongan(short id) {
		return (Golongan) factory.createEntityManager()
				.createQuery("from Golongan where golonganId=" + id)
				.getSingleResult();
		
	}
	
	public boolean addGolongan(Golongan golongan) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			//eManager.persist(new Date());
			eManager.persist(golongan);
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			//log.error("DAO Error", ex.getMessage());
			
			
		}
			return isSuccess;
	}
	
	public boolean editGolongan(Golongan updatedGolongan) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Golongan existingGolongan = (Golongan) eManager.find(Golongan.class, updatedGolongan.getGolonganId());
			existingGolongan.setNama(updatedGolongan.getNama());
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			
		}
			return isSuccess;
	}


}
