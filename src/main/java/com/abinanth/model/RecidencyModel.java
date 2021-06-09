package com.abinanth.model;

public class RecidencyModel {
	private String newRecidency;

	public RecidencyModel(String newRecidency) {
		super();
		this.newRecidency = newRecidency;

	}

	public String getNewRecidency() {
		return newRecidency;
	}

	public void setNewRecidency(String newRecidency) {
		this.newRecidency = newRecidency;
	}

	@Override
	public String toString() {
		return "RecidencyModel [newRecidency=" + newRecidency + "]";
	}

}
