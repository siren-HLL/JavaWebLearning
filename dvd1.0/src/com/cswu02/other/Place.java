package com.cswu02.other;

public class Place {
	private int id;
	private int parent_id;
	private String cname;
	private int ctype;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	
	public Place(int id, int parent_id, String cname, int ctype) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.cname = cname;
		this.ctype = ctype;
	}

	public Place() {};

}
