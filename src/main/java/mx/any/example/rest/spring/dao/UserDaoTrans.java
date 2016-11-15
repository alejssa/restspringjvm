package mx.any.example.rest.spring.dao;

import mx.any.example.rest.spring.dto.UserDto;

public interface UserDaoTrans {

	public int editUser(UserDto user) throws Exception;
	
	public int addUser(UserDto user) throws Exception;
	
}
