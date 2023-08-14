package com.ofss.MutualFundsApp.model;

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
@Table(name = "shares")
public class Shares {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shareId;
	private String shareName;
	private float closingPrice;
	private String businessCategory;
	
	 @ElementCollection
	 @CollectionTable(name = "prev_price_details", joinColumns = @JoinColumn(name = "entity_id"))
	 @Column(name = "price_detail")
	private List<String> prevPriceDetails;
	
	public Shares() {
		// TODO Auto-generated constructor stub
	}

	public Shares(int shareId, String shareName, float closingPrice, String businessCategory,
			List<String> prevPriceDetails) {
		super();
		this.shareId = shareId;
		this.shareName = shareName;
		this.closingPrice = closingPrice;
		this.businessCategory = businessCategory;
		this.prevPriceDetails = prevPriceDetails;
	}

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(float closingPrice) {
		this.closingPrice = closingPrice;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public List<String> getPrevPriceDetails() {
		return prevPriceDetails;
	}

	public void setPrevPriceDetails(List<String> prevPriceDetails) {
		this.prevPriceDetails = prevPriceDetails;
	}

	@Override
	public String toString() {
		return "Shares [shareId=" + shareId + ", shareName=" + shareName + ", closingPrice=" + closingPrice
				+ ", businessCategory=" + businessCategory + ", prevPriceDetails=" + prevPriceDetails + "]";
	}
	
	
	
	

}
