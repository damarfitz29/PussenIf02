package id.co.pussenif.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.pussenif.model.Presensi;
import id.co.pussenif.model.User;

@Service
public class PresensiDAO {

		@Autowired
		private EntityManagerFactory factory;
		
		public List<Presensi> getAllPresensi(){
			return factory.createEntityManager()
					.createQuery("from Presensi where isActive = 0")
					.getResultList();
		}
		
		public Presensi getPresensi(short id) {
			return (Presensi) factory.createEntityManager()
					.createQuery("from Presensi where presensiId=" + id)
					.getSingleResult();
			
		}
		
		public boolean addPresensi(Presensi presensi) {
			EntityManager eManager = factory.createEntityManager();
			EntityTransaction transaksi = null;
			boolean isSuccess = true;
			try {
				transaksi = eManager.getTransaction();
				transaksi.begin();
				//eManager.persist(new Date());
				presensi.setIsActive(0);
				eManager.persist(presensi);
				transaksi.commit();
			}catch(Exception ex) {
				transaksi.rollback();
				isSuccess = false;
				//log.error("DAO Error", ex.getMessage());
				
				
			}
				return isSuccess;
		}
}
