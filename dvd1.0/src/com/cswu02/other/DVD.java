package com.cswu02.other;

public class DVD {
	private String title;
	private int year;
	private int binder;
	private int page;
	private int slot;
	private String viewed;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getBinder() {
		return binder;
	}
	public void setBinder(int binder) {
		this.binder = binder;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public String getViewed() {
		return viewed;
	}
	public void setViewed(String viewed) {
		this.viewed = viewed;
	}
	public DVD(String title, int year, int binder, int page, int slot, String viewed) {
		super();
		this.title = title;
		this.year = year;
		this.binder = binder;
		this.page = page;
		this.slot = slot;
		this.viewed = viewed;
	}
	public DVD(){};
	
}
