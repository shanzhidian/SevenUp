package org.sevenup.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;
@XmlRootElement(name="User")
@XmlAccessorType (XmlAccessType.FIELD)
public class User extends ResourceSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643083900558470878L;

	@XmlElement(required=true)
	private String userName;
	@XmlElement(required=true)
	private String email;
	@XmlElement(required=true)
	private String password;

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

}
