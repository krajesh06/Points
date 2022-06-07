package com.ecommerceapp.points.dto;



import lombok.Data;

@Data

public class MessageDTO {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageDTO(String message) {
		super();
		this.message = message;
	}
    private int points;
}