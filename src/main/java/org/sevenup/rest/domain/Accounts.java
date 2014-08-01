package org.sevenup.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.hateoas.ResourceSupport;


@XmlRootElement(name="accounts")
@XmlAccessorType (XmlAccessType.FIELD)
public class Accounts extends ResourceSupport implements Serializable{

    @XmlElement(name="account")
	private List<Account> accounts = null;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
    
}
