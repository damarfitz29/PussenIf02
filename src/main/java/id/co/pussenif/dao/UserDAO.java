package id.co.pussenif.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.pussenif.model.User;



@Service
public class UserDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<User> getAllUser(){
		return factory.createEntityManager()
				.createQuery("from User where isActive = 0")
				.getResultList();
	}
	
	public User getUser(short id) {
		return (User) factory.createEntityManager()
				.createQuery("from User where userId=" + id)
				.getSingleResult();
		
	}
	
	public boolean addUser(User user) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			//eManager.persist(new Date());
			user.setIsActive(0);
			eManager.persist(user);
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			//log.error("DAO Error", ex.getMessage());
			
			
		}
			return isSuccess;
	}
	
	public boolean editUser(User updatedUser) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			User existingUser = (User) eManager.find(User.class, updatedUser.getUserId());
			existingUser.setNama(updatedUser.getNama());
			existingUser.setLevel(updatedUser.getLevel());
			existingUser.setPassword(updatedUser.getPassword());
			existingUser.setIsActive(updatedUser.getIsActive());
			transaksi.commit();
		}catch(Exception ex) {
			transaksi.rollback();
			ex.printStackTrace();
			isSuccess = false;
			
		}
			return isSuccess;
	}

}
