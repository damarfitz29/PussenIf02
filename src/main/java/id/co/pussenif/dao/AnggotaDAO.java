package id.co.pussenif.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.pussenif.model.Anggota;


@Service
public class AnggotaDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<Anggota> getAllAnggota(){
		return factory.createEntityManager()
				.createQuery("from Anggota where isActive=0 ")
				.getResultList();
	}
	
	public Anggota getAnggota(short id) {
		return (Anggota) factory.createEntityManager()
				.createQuery("from Anggota where actorId=" + id)
				.getSingleResult();
		
	}
	
	public boolean addAnggota(Anggota anggota) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			anggota.setLastUpdate(new Date());
			eManager.persist(anggota);
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			//log.error("DAO Error", ex.getMessage());
			
			
		}
			return isSuccess;
	}
	
	public boolean editAnggota(Anggota updatedAnggota) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Anggota existingAnggota = (Anggota) eManager.find(Anggota.class, updatedAnggota.getAnggotaId());
			existingAnggota.setNrp(updatedAnggota.getNrp());
			existingAnggota.setNama(updatedAnggota.getNama());
			existingAnggota.setAlamat(updatedAnggota.getAlamat());
			existingAnggota.setTanggalLahir(updatedAnggota.getTanggalLahir());
			existingAnggota.setGolonganId(updatedAnggota.getGolonganId());
			existingAnggota.setDivisiId(updatedAnggota.getDivisiId());
			existingAnggota.setAgama(updatedAnggota.getAgama());
			existingAnggota.setJnsKelamin(updatedAnggota.getJnsKelamin());
			existingAnggota.setStatus(updatedAnggota.getStatus());
			existingAnggota.setTglAktif(updatedAnggota.getTglAktif());
			existingAnggota.setFoto(updatedAnggota.getFoto());
			existingAnggota.setLastUpdate(new Date());
			existingAnggota.setIsActive(updatedAnggota.getIsActive());
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			
		}
			return isSuccess;
	}
}
