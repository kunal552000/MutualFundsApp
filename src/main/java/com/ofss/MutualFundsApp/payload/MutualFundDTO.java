package com.ofss.MutualFundsApp.payload;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ofss.MutualFundsApp.model.Shares;

@Component
public class MutualFundDTO {
	
	  private String mfName;
	  private List<SharesRequest> includedShares;
	public String getMfName() {
		return mfName;
	}
	public void setMfName(String mfName) {
		this.mfName = mfName;
	}
	public List<SharesRequest> getIncludedShares() {
		return includedShares;
	}
	public void setIncludedShares(List<SharesRequest> includedShares) {
		this.includedShares = includedShares;
	}
	
	  
	  
	  
	  
	
}
