package org.sevenup.rest.domain;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
 * 
 * @author steven
 * for account login and basic show
 */
@XmlRootElement(name="account")
@XmlAccessorType (XmlAccessType.FIELD)
public class Account extends ResourceSupport implements Serializable{
	
	private static final long serialVersionUID = 2842556684073870772L;
	@XmlElement(required=true)
	private String accountName;
	@XmlElement(required=true)
	private String email;
	@XmlElement(required=true)
	private String password;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
