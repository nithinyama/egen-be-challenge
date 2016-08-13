package com.app.entities;

public class Sensor {

	private String timestamp;
	private int weight;
	private String alert;
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getAlert() {
		return alert;
	}
	
}
