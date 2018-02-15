package id.co.pussenif.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.pussenif.model.Anggota;
import id.co.pussenif.model.Divisi;



@Service
public class DivisiDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Divisi> getAllDivisi(){
		return factory.createEntityManager()
				.createQuery("from Divisi")
				.getResultList();
	}
	
	public Divisi getDivisi(short id) {
		return (Divisi) factory.createEntityManager()
				.createQuery("from Divisi where divisiId=" + id)
				.getSingleResult();
		
	}
	
	public boolean addDivisi(Divisi divisi) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			eManager.persist(new Date());
			eManager.persist(divisi);
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			//log.error("DAO Error", ex.getMessage());
			
			
		}
			return isSuccess;
	}
	
	public boolean editDivisi(Divisi updatedDivisi) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Divisi existingDivisi = (Divisi) eManager.find(Divisi.class, updatedDivisi.getDivisiId());
			existingDivisi.setNama(updatedDivisi.getNama());
			existingDivisi.setLevel(updatedDivisi.getLevel());
			existingDivisi.setParentId(updatedDivisi.getParentId());
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			
		}
			return isSuccess;
	}


}
