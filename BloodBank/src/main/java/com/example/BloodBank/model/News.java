package com.example.BloodBank.model;

import javax.persistence.Entity;

import lombok.Data;

public class News {

	private String id;
	private String content;
//	private Date date;
	public News() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
