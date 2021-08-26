package web.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.entity.UserLogin;
import web.com.repository.LoginRepo;

@Service
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private LoginRepo service;

	@Override
	public void register(UserLogin user) {
		service.save(user);
		
	}

	@Override
	public boolean verification(String username, String password) {
		
		
		UserLogin user=service.findUser(username, password);
		
		if(user==null)
		{
			return false;
		}
		
		if(user.getUsername().equals(username)&&user.getPassword().equals(password))
		{
			return true;
		}

		
		return false;
	}

}
