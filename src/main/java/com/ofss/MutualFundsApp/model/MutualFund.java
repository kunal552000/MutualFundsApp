package com.ofss.MutualFundsApp.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "mutual_fund")
public class MutualFund {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mfId;
	private String mfName;
	private float expenseRatio;
	
	@ElementCollection
	@CollectionTable(name = "exit_loads", joinColumns = @JoinColumn(name = "mf_id"))
	@MapKeyColumn(name = "load_type")
	@Column(name = "load_percentage")
	private Map<String,Float> exitLoad;
	
	private float nav;
	
	@OneToMany
	@ElementCollection
	 @CollectionTable(name = "shares_mapping", joinColumns = @JoinColumn(name = "mf_id"))
	 @Column(name = "share_id")
	private List<Shares> includedShares;
	
	public MutualFund() {
		// TODO Auto-generated constructor stub
	}

	public MutualFund(int mfId, String mfName, float expenseRatio, Map<String, Float> exitLoad, float nav,
			List<Shares> includedShares) {
		super();
		this.mfId = mfId;
		this.mfName = mfName;
		this.expenseRatio = expenseRatio;
		this.exitLoad = exitLoad;
		this.nav = nav;
		this.includedShares = includedShares;
	}

	public int getMfId() {
		return mfId;
	}

	public void setMfId(int mfId) {
		this.mfId = mfId;
	}

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	public float getExpenseRatio() {
		return expenseRatio;
	}

	public void setExpenseRatio(float expenseRatio) {
		this.expenseRatio = expenseRatio;
	}

	public Map<String, Float> getExitLoad() {
		return exitLoad;
	}

	public void setExitLoad(Map<String, Float> exitLoad) {
		this.exitLoad = exitLoad;
	}

	public float getNav() {
		return nav;
	}

	public void setNav(float nav) {
		this.nav = nav;
	}

	public List<Shares> getIncludedShares() {
		return includedShares;
	}

	public void setIncludedShares(List<Shares> includedShares) {
		this.includedShares = includedShares;
	}

	@Override
	public String toString() {
		return "MutualFund [mfId=" + mfId + ", mfName=" + mfName + ", expenseRatio=" + expenseRatio + ", exitLoad="
				+ exitLoad + ", nav=" + nav + ", includedShares=" + includedShares + "]";
	}
	
	
	
	
	
	

}
