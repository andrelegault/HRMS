package main;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import main.DAO;

@ManagedBean
public class IndexCtrl {

	public List<User> getUserList()
	{
		DAO dao = new DAO();
		
		return dao.getAllUsersFromDB();
		
	}
}
