package com.accenture.bean;

public class LookUpBean {
	@Override
	public String toString() {
		return "LookUpBean [id=" + id + ", text=" + text + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private int id;
	private String text;

}
