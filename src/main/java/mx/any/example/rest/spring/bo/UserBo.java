package mx.any.example.rest.spring.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.any.example.rest.spring.dao.UserDao;
import mx.any.example.rest.spring.dao.UserDaoTrans;
import mx.any.example.rest.spring.dto.UserDto;
import mx.any.example.rest.spring.dto.json.UserDeserializer;

public class UserBo {
	
	@Autowired
	private UserDao userDao; 
	
	@Autowired
	private UserDaoTrans userDaoTrans;
	
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}


	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

	
	/**
	 * @return the userDaoTrans
	 */
	public UserDaoTrans getUserDaoTrans() {
		return userDaoTrans;
	}


	/**
	 * @param userDaoTrans the userDaoTrans to set
	 */
	public void setUserDaoTrans(UserDaoTrans userDaoTrans) {
		this.userDaoTrans = userDaoTrans;
	}

	public Map<String, Object> login(String json){
		
		Map<String,Object> jsonResp = new TreeMap<String,Object>();
		
		try{
			
			UserDto user = parseJsonUser(json);
			
			boolean authenticated = userDao.login(user) > 0 ? true : false;
			jsonResp.put("success", authenticated);
			
		} catch (Exception e) {
			
			jsonResp.put("error", e.getClass());
		}
		return jsonResp;
		
	}

	public Map<String,Object> allUser(){
		Map<String,Object> jsonUser = new TreeMap<String,Object>();
		Map<String,Object> jsonUserAux = null;
		List<Map<String,Object>> arrayJson = new ArrayList<Map<String,Object>>();
		try{
			
			List<UserDto> usuarios = userDao.allUser();
			for(UserDto user: usuarios){
				jsonUserAux = new TreeMap<String, Object>();
				jsonUserAux.put("nombre", user.getNombre());
				jsonUserAux.put("apaterno", user.getApellido());
				jsonUserAux.put("email", user.getEmail());
				jsonUserAux.put("pass", user.getPassword());
				arrayJson.add(jsonUserAux);
			}
			jsonUser.put("usuarios", arrayJson);
		} catch (Exception e) {
			jsonUser.put("error", e.getClass());
		}
		return jsonUser;
	}
	
	
	public Map<String,Object> getUserId(String id){
		Map<String,Object> jsonUser = new TreeMap<String,Object>();
		try{
			UserDto usuario = userDao.getUserId(new Integer(id));
			jsonUser.put("nombre", usuario.getNombre());
			jsonUser.put("apaterno", usuario.getApellido());
			jsonUser.put("email", usuario.getEmail());
			jsonUser.put("pass", usuario.getPassword());
			
		} catch (Exception e) {
			jsonUser.put("error", e.getClass());
		}
		return jsonUser;
	}

	public Map<String,Object> editUser(String json){
		Map<String,Object> jsonResp = new TreeMap<String,Object>();
		int count = 0;
		try{
			
			UserDto user = parseJsonUser(json);
			count = userDaoTrans.editUser(user);
			jsonResp.put("success", count);
			
		} catch (Exception e) {
			jsonResp.put("error", e.getClass());
		}
		return jsonResp;
	}
	
	public Map<String,Object> addUser(String json){
		Map<String,Object> jsonResp = new TreeMap<String,Object>();
		int count = 0;
		try{
			
			UserDto user = parseJsonUser(json);
			count = userDaoTrans.addUser(user);
			jsonResp.put("success", count);
			
		} catch (Exception e) {
			jsonResp.put("error", e.getClass());
		}
		return jsonResp;
	}
	
	private UserDto parseJsonUser(String userJson) throws Exception{
		 
		UserDto user = null;
		
		try{
			String json = userJson; 
			
			GsonBuilder gsonBuilder = new GsonBuilder();
		    gsonBuilder.registerTypeAdapter(UserDto.class, new UserDeserializer());
		    Gson gson = gsonBuilder.create();
		    user = gson.fromJson(json, UserDto.class);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return user;
	}
	
	

}
