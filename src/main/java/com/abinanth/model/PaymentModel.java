package com.abinanth.model;

public class PaymentModel {

	private String recidencyNo;
	private String recidencyType;
	private String amount;
	private String status;
	private String username;
	private int paymentId;

	public String getRecidencyNo() {
		return recidencyNo;
	}

	public void setRecidencyNo(String recidencyNo) {
		this.recidencyNo = recidencyNo;
	}

	public String getRecidencyType() {
		return recidencyType;
	}

	public void setRecidencyType(String recidencyType) {
		this.recidencyType = recidencyType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public String toString() {
		return "PaymentModel [recidencyNo=" + recidencyNo + ", recidencyType=" + recidencyType + ", amount=" + amount
				+ ", status=" + status + ", username=" + username + ", paymentId=" + paymentId + "]";
	}

	public PaymentModel(String recidencyNo, String recidencyType, String amount, String status, String username,
			int paymentId) {
		super();
		this.recidencyNo = recidencyNo;
		this.recidencyType = recidencyType;
		this.amount = amount;
		this.status = status;
		this.username = username;
		this.paymentId = paymentId;
	}

	public PaymentModel() {
		// default constructor
	}

}