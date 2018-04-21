package com.kafka.dto;

import java.util.Date;

public class Message {

	private String msgId;
	private Date dateTime;
	private Double value;
	
	
	
	
	public Message(String msgId, Date dateTime, Double value) {
		super();
		this.msgId = msgId;
		this.dateTime = dateTime;
		this.value = value;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
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
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", dateTime=" + dateTime + ", value=" + value + "]";
	}
	
	
}
