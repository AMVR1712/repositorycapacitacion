package org.dao.usercap;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.usercap.UserCap;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DAOImplUserCap implements DAO_UserCap {
	
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addUser_Cap(UserCap userCap) {
		
		try {
			session.saveOrUpdate(userCap);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCap> listUserCap() {
		List<UserCap> list = null;
		try {
			list = (List<UserCap>) session.createQuery("from Usercap").list();
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return list;
	}

	@Override
	public UserCap getUserCapById(int id) {
		UserCap userCap = null;
		try {
			userCap = (UserCap) session.get(UserCap.class, id);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return userCap;
	}

	@Override
	public void deleteUserCap(int id) {
		UserCap userCap = null;
		try {
			userCap = (UserCap) session.get(UserCap.class, id);
			session.delete(userCap);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}

}
