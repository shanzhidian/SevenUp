package org.sevenup.core.domain.common;

public abstract class Privilege {
	private String privilegeId;
	private String privilegeNumber;
	private String privilegeName;
	
	private int privilegeLevel;

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeNumber() {
		return privilegeNumber;
	}

	public void setPrivilegeNumber(String privilegeNumber) {
		this.privilegeNumber = privilegeNumber;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public int getPrivilegeLevel() {
		return privilegeLevel;
	}

	public void setPrivilegeLevel(int privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}
	
}
