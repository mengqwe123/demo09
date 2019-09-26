package dao.factory;

import dao.IUserDAO;
import dao.proxy.UserDAOProxy;

public class DAOFactory {
public static IUserDAO getIUserDAOInstance() {
	
	return new UserDAOProxy();
}
}
