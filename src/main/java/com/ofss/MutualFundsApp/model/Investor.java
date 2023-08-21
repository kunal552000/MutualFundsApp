package com.ofss.MutualFundsApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "investor")
public class Investor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investorId;
	private String investorName;
	private String email;
	private String password;
	
	@ElementCollection
	@CollectionTable(name = "investments", joinColumns = @JoinColumn(name = "investorId"))
	@Column(name = "mutualFund_id")
	private List<Integer> investments = new ArrayList<>();
	
    public Investor() {
		// TODO Auto-generated constructor stub
	}

	public Investor(int investorId, String investorName, String email, String password, List<Integer> investments) {
		super();
		this.investorId = investorId;
		this.investorName = investorName;
		this.email = email;
		this.password = password;
		this.investments = investments;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
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

	public List<Integer> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Integer> investments) {
		this.investments = investments;
	}

	@Override
	public String toString() {
		return "Investor [investorId=" + investorId + ", investorName=" + investorName + ", email=" + email
				+ ", password=" + password + ", investments=" + investments + "]";
	}
    
    
	
	
	
	
	

}
