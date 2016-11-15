package mx.any.example.rest.spring.dao;

import java.util.List;

import mx.any.example.rest.spring.dto.UserDto;

public interface UserDao {

	public int login(UserDto user) throws Exception;
	
	public List<UserDto> allUser() throws Exception;
	
	public UserDto getUserId(int id) throws Exception;
}
