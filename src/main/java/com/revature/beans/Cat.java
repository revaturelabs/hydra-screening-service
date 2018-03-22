package com.revature.beans;

public class Cat {
	private String name;
	private int catId;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(String name, int catId) {
		super();
		this.name = name;
		this.catId = catId;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", catId=" + catId + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	
}
