package org.sevenup.core.domain;

import java.util.Date;

import org.sevenup.core.events.account.AccountDetails;
import org.springframework.beans.BeanUtils;

/**
 * 
 * @author steven.xu
 *
 */
public class User {
	
	private String userId;
	private String userName;
	private String email;
	private String password;

	private String description;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
