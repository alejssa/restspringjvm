package mx.any.example.rest.spring.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.any.example.rest.spring.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto>{

	public UserDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
		userDto.setApellido(resultSet.getString("apellido"));
		userDto.setEmail(resultSet.getString("email"));
		userDto.setId(resultSet.getInt("id_usuario"));
		userDto.setNombre(resultSet.getString("nombre"));
		userDto.setPassword(resultSet.getString("password"));
		return userDto;
	}
	

}
