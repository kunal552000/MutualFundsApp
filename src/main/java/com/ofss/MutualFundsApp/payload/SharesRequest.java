package com.ofss.MutualFundsApp.payload;

public class SharesRequest {
	
	 private int shareId;
	 private int weightage;
	 private int noOfUnits;
//	public SharesRequest(int shareId, int weightage, int noOfUnits) {
//		super();
//		this.shareId = shareId;
//		this.weightage = weightage;
//		this.noOfUnits = noOfUnits;
//	}
	public int getShareId() {
		return shareId;
	}
	public void setShareId(int shareId) {
		this.shareId = shareId;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	
	
	
	 
}
