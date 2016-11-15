package mx.any.example.rest.spring.services;

import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.any.example.rest.spring.bo.UserBo;

@Controller
public class UserService {

	@Autowired
	private UserBo userBo; 
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(@RequestBody String jsonUserLogin) throws ServletException{
		return userBo.login(jsonUserLogin);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> allUser() throws ServletException{
		return userBo.allUser();
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getUserId(@PathVariable String id) throws ServletException{
		return userBo.getUserId(id);
		
	}
	
}
