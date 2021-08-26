package web.com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import web.com.entity.UserLogin;

public interface LoginRepo extends JpaRepository<UserLogin, Integer>{
	
	@Query("from UserLogin user where user.username=:us and user.password=:ps")
	 UserLogin findUser(@Param("us")String username,@Param("ps")String password);
	

}
