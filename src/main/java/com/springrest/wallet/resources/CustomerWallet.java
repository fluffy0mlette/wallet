package com.springrest.wallet.resources;

public class CustomerWallet {
	private Integer custId;
	private Double amount;
	
	public CustomerWallet(Integer custId, Double balance) {
		super();
		this.custId = custId;
		this.amount = balance;
	}
	
	public CustomerWallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CustomerWallet [custId=" + custId + ", Balance=" + amount + "]";
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double balance) {
		this.amount = balance;
	}

	
}