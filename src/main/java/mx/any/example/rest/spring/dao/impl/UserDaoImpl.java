package mx.any.example.rest.spring.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import mx.any.example.rest.spring.dao.UserDao;
import mx.any.example.rest.spring.dao.mappers.UserRowMapper;
import mx.any.example.rest.spring.dto.UserDto;

public class UserDaoImpl extends NamedParameterJdbcDaoSupport implements UserDao {

	private Map<String, Object> parametros = null;
	
	public int login(UserDto user) throws Exception{
		int authenticated = 0;
		try{
			
			String query = "SELECT COUNT(*) from usuarios WHERE name = :name AND password = :pass";
			parametros = new HashMap<String, Object>();
			parametros.put("name", user.getNombre());
			parametros.put("pass", user.getPassword());
			authenticated = getNamedParameterJdbcTemplate().queryForObject(query, parametros, Integer.class);
			logger.debug(query);
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return authenticated; 
	}
	
	public List<UserDto> allUser() throws Exception{
		
		List<UserDto> users = new ArrayList<UserDto>(); 
		
		try{
			String query = "SELECT id, name, lastname, email, password FROM usuarios"; 
			parametros = new HashMap<String, Object>();
			users = getNamedParameterJdbcTemplate().query(query, parametros, new UserRowMapper());
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return users;
	}
	
	public UserDto getUserId(int id) throws Exception{
		
		UserDto user = new UserDto ();
		try{
			
			String query = "SELECT id, name, lastname, email, password FROM usuarios WHERE id_usuario = :id";
			parametros = new HashMap<String, Object>();
			parametros.put("id", id);
			user = getNamedParameterJdbcTemplate().queryForObject(query, parametros, new UserRowMapper());
			logger.debug(query);
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return user; 
	}

}
