package org.action.usercap;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.usercap.DAOImplUserCap;
import org.dao.usercap.DAO_UserCap;
import org.modelo.usercap.UserCap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionUserCap extends ActionSupport implements ModelDriven<UserCap> {
	
	private UserCap userCap = new UserCap();
	private DAO_UserCap dao = new DAOImplUserCap();
	private List<UserCap> listaUserCap = new ArrayList<UserCap>();
	
	public String execute() {
		return SUCCESS;
	}
	
	public String add() {
		dao.addUser_Cap(userCap);
		return SUCCESS;
	}
	
	public String list() {
		setListaUserCap(dao.listUserCap());
		return SUCCESS;
	}
	
	public String edit() {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		userCap = dao.getUserCapById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delete() {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.deleteUserCap(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	//Getters and Setters de userCap y listaUserCap
	
	@Override
	public UserCap getModel() {
		return userCap;
	}
	
	public UserCap getUserCap() {
		return userCap;
	}
	public void setUserCap(UserCap userCap) {
		this.userCap = userCap;
	}
	public List<UserCap> getListaUserCap() {
		return listaUserCap;
	}
	public void setListaUserCap(List<UserCap> listaUserCap) {
		this.listaUserCap = listaUserCap;
	}

}
