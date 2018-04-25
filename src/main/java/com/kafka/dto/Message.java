package com.kafka.dto;

import java.util.Date;

public class Message {
	
	private String msgId;
	private Date dateTime;
	private Double value;
	private Double percentageChange;
	
	
	

	
	public Message(String msgId, Date dateTime, Double value, Double percentageChange) {
		super();
		this.msgId = msgId;
		this.dateTime = dateTime;
		this.value = value;
		this.percentageChange = percentageChange;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getPercentageChange() {
		return percentageChange;
	}

	public void setPercentageChange(Double percentageChange) {
		this.percentageChange = percentageChange;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	
	

}
