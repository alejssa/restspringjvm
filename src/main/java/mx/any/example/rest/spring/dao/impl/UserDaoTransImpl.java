package mx.any.example.rest.spring.dao.impl;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import mx.any.example.rest.spring.dao.UserDaoTrans;
import mx.any.example.rest.spring.dto.UserDto;

public class UserDaoTransImpl implements UserDaoTrans{

	
	private PlatformTransactionManager transactionManager;
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @return the transactionManager
	 */
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * @param transactionManager the transactionManager to set
	 */
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int editUser(UserDto user) throws Exception{
		//TODO: to implement
		return 0;
	}
	
	
	public int addUser(UserDto user) throws Exception{
		//TODO: to implement
		return 0;
	}

}
