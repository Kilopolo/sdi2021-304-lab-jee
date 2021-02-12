package com.uniovi.sdi;

public class Post {

	private String name;
	private String title;
	private String text;
	
	public Post() {
	}
	
	public Post(String name, String title, String text) {
		super();
		this.name = name;
		this.title = title;
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
