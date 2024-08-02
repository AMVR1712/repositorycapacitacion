package org.dao.usercap;import java.util.List;

import org.modelo.usercap.UserCap;

public interface DAO_UserCap {

	public void addUser_Cap(UserCap userCap);
	public List<UserCap> listUserCap();
	public UserCap getUserCapById(int id);
	public void deleteUserCap(int id);
	
}
