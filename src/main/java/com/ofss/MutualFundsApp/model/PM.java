package com.ofss.MutualFundsApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio_manager")
public class PM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pmId;
	private String pmName;
	private String email;
	private String password;
	
	public PM() {
		// TODO Auto-generated constructor stub
	}

	public PM(int pmId, String pmName, String email, String password) {
		super();
		this.pmId = pmId;
		this.pmName = pmName;
		this.email = email;
		this.password = password;
	}

	public int getPmId() {
		return pmId;
	}

	public void setPmId(int pmId) {
		this.pmId = pmId;
	}

	public String getPmName() {
		return pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + pmId;
		result = prime * result + ((pmName == null) ? 0 : pmName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PM other = (PM) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pmId != other.pmId)
			return false;
		if (pmName == null) {
			if (other.pmName != null)
				return false;
		} else if (!pmName.equals(other.pmName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PM [pmId=" + pmId + ", pmName=" + pmName + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	

}
