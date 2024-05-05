package com.sarthak.restfult.webservices.social.media.controller;

public class EnhancedMsg {
	
	private String name;
	
	public EnhancedMsg(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EnhancedMsg [name=" + name + "]";
	}
	
}
