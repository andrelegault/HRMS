package main;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.DAO;

@ManagedBean
@RequestScoped
public class IndexCtrl {

	private List<User> userList;
	
	public void setUserList(List<User> ul)
	{
		userList = ul;
	}
	
	public List<User> getUserList()
	{
		DAO dao = new DAO();
		userList = dao.getAllUsersFromDB();
		return userList;
		
	}

	
}
