package com.example.BloodBank.dto;

import java.util.Date;

import com.example.BloodBank.model.News;

public class MessageDto {
    private String text;
    private News content;
    

	private Date timestamp;

    public MessageDto() {
    }

    public MessageDto(String text, Date timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

	public News getContent() {
		return content;
	}

	public void setContent(News content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MessageDto [text=" + text + ", content=" + content + ", timestamp=" + timestamp + "]";
	}
    
    

    
}
