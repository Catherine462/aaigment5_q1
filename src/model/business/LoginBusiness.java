package model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

public class LoginBusiness {
	
	private LoginDataAccess loginAccess;
	private String userName = "";
	private String password = "";
	
	
	public LoginBusiness()
	{
		loginAccess = new LoginDataAccess();
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
		
		if (userName.equals("")) {
			throw new MessageException("Please enter username");
		}
	}
	
	public void setPassword(String password) {
		this.password = password;
		
		if (password.equals("")) {
			throw new MessageException("Please enter password");
		} 

	}
	
	public boolean verifyCredentials() throws ClassNotFoundException, SQLException {
		User user = new User(userName, password);
		
		if(this.loginAccess.verifyCredentials(user)) {
			return true;
		}
		else {
			throw new MessageException("Incorrect credentials.");
		}		
	}
	
	




}
