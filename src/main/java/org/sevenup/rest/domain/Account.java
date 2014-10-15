package org.sevenup.rest.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.sevenup.core.events.account.AccountDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.ResourceSupport;

/**
 * Account Class used in the rest perspective Developer can control the fields
 * 
 * @author steven.xu
 *
 */
@XmlRootElement(name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account extends ResourceSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7110628902672169040L;

	@XmlElement(required = true)
	private String accountName;
	@XmlElement(required = true)
	private String email;
	@XmlElement(required = true)
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

	//added by rqf
		private final Date dateTimeOfRegister;
		private UUID key;
		
		public Account(){
			dateTimeOfRegister = null;
		}
		public Account(final Date dateTimeOfRegister){
			this.key = UUID.randomUUID();  //需要新主键才对
			this.dateTimeOfRegister = dateTimeOfRegister;
		}
		
		public static Account fromAccountDetails(AccountDetails userDetails){
			Account account = new Account(userDetails.getDateTimeOfRegister());
			BeanUtils.copyProperties(userDetails, account);
			return account;
		}
		
		public AccountDetails toAccountDetails(){
			AccountDetails accountDetails = new AccountDetails();
			BeanUtils.copyProperties(this, accountDetails);
			return accountDetails;
		}

		public UUID getKey() {
			return key;
		}

		public void setKey(UUID key) {
			this.key = key;
		}

		public Date getDateTimeOfRegister() {
			return dateTimeOfRegister;
		}
}
