package com.abinanth.model;

public class PaymentModel {

	private String recidencyNo;
	private String recidencyType;
	private String amount;
	private String status;

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

	public String getRecidencyNo() {
		return recidencyNo;
	}

	public void setRecidencyNo(String recidencyNo) {
		this.recidencyNo = recidencyNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentModel(String recidencyType, String amount, String recidencyNo, String status) {
		super();
		this.recidencyType = recidencyType;
		this.amount = amount;
		this.recidencyNo = recidencyNo;
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "PaymentModel [recidencyNo=" + recidencyNo + ", recidencyType=" + recidencyType + ", amount=" + amount
				+ ", status=" + status + "]";
	}

}