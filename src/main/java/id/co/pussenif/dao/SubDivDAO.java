package id.co.pussenif.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.pussenif.model.Subdivisi;



@Service
public class SubDivDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Subdivisi> getAllSubdivisi(){
		return factory.createEntityManager()
				.createQuery("from Subdivisi where isActive = 0")
				.getResultList();
	}
	
	public Subdivisi getSubdivisi(short id) {
		return (Subdivisi) factory.createEntityManager()
				.createQuery("from Subdivisi where subdivId=" + id)
				.getSingleResult();
		
	}
	
	public boolean addSubdivisi(Subdivisi subdivisi) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			//eManager.persist(new Date());
			eManager.persist(subdivisi);
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			//log.error("DAO Error", ex.getMessage());
			
			
		}
			return isSuccess;
	}
	
	public boolean editSubdivisi(Subdivisi updatedSubdivisi) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Subdivisi existingSubdivisi = (Subdivisi) eManager.find(Subdivisi.class, updatedSubdivisi.getSubdivId());
			existingSubdivisi.setNama(updatedSubdivisi.getNama());
			existingSubdivisi.setLastUpdate(new Date());
			existingSubdivisi.setIsActive(updatedSubdivisi.getIsActive());
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			ex.printStackTrace();
			isSuccess = false;
			
		}
			return isSuccess;
	}

}
