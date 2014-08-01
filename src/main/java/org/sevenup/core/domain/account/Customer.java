package org.sevenup.core.domain.account;

import org.sevenup.core.domain.common.Account;


/**
 * 
 * @author steven
 * 
 */
public class Customer extends Account {
	private int age;
//	private boolean sex;
	private String profession;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
