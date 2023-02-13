package com.hb.evaluation.models;

public class Message {

	private Integer id;
	private String content;
	private String category;

	public Message() {

	}

	public Message(Integer id, String content, String category) {
		super();
		this.id = id;
		this.content = content;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
