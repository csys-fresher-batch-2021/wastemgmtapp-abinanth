package com.abinanth.model;

import java.time.LocalDate;

public class PaymentModel {

	private String username;
	private int recidencyNo;
	private String recidencyType;
	private double amount;
	private String status;
	private int paymentId;
	private LocalDate dueDate;
	private double fineAmount;
	private LocalDate paidDate;
	private double totalAmount;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRecidencyNo() {
		return recidencyNo;
	}

	public void setRecidencyNo(int recidencyNo) {
		this.recidencyNo = recidencyNo;
	}

	public String getRecidencyType() {
		return recidencyType;
	}

	public void setRecidencyType(String recidencyType) {
		this.recidencyType = recidencyType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDue_date(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFine_amount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaid_date(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public PaymentModel(String username, int recidencyNo, String recidencyType, double amount, String status,
			int paymentId, LocalDate dueDate, double fineAmount, LocalDate paidDate, double totalAmount) {
		super();
		this.username = username;
		this.recidencyNo = recidencyNo;
		this.recidencyType = recidencyType;
		this.amount = amount;
		this.status = status;
		this.paymentId = paymentId;
		this.dueDate = dueDate;
		this.fineAmount = fineAmount;
		this.paidDate = paidDate;
		this.totalAmount = totalAmount;
	}

	public PaymentModel() {
		super();

	}

	@Override
	public String toString() {
		return "PaymentModel [username=" + username + ", recidencyNo=" + recidencyNo + ", recidencyType="
				+ recidencyType + ", amount=" + amount + ", status=" + status + ", paymentId=" + paymentId
				+ ", dueDate=" + dueDate + ", fineAmount=" + fineAmount + ", paidDate=" + paidDate + ", totalAmount="
				+ totalAmount + "]";
	}

}