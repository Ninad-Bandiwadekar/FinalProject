package web.com.service;

import web.com.entity.UserLogin;

public interface LoginDao {
	
	void register(UserLogin user);
	
	boolean verification(String username,String password);

}
