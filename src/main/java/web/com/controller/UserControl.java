package web.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import web.com.entity.UserLogin;
import web.com.service.LoginDaoImpl;


@Controller
public class UserControl {
	
	@Autowired
	private LoginDaoImpl service;
	
	@GetMapping("/")
	public String landing(Model model)
	{
		UserLogin user=new UserLogin();
		model.addAttribute("user",user);
		return "index";
	}
	
	@PostMapping("/addUser")
	public String register(@ModelAttribute UserLogin user,Model model )
	{
		UserLogin user1=new UserLogin();
		service.register(user);
		model.addAttribute("user", user1);
		return "login";
	}
	
	@GetMapping("/validate")
	public String login(@ModelAttribute UserLogin user,Model model )
	{
		/*
		 * UserLogin user1=new UserLogin(); model.addAttribute("user", user1);
		 */
		String username=user.getUsername();
		String password=user.getPassword();
		if(service.verification(username,password))
		{
			return "home";
		}
		return "redirect:/";
	}
	
	@GetMapping("/userlogin")
	public String UserLogin(Model model)
	{
		UserLogin user1=new UserLogin();
		model.addAttribute("user", user1);
		return "login";
	}
	
	@GetMapping("/logout")
	public String Logout()
	{
		return "redirect:/";
	}

	

}
