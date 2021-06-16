package com.sybinal.shop.model;

import java.util.List;

public class FaPiao {
	 private String dwmc;//单位名称，发票抬头
	 private Integer id;	//纳税人识别码，企业税号
	 private String zcdz;//注册地址
	 private String phone;//注册电话
	 private String open_bank;//开户银行
	 private String bank_ID;//银行账户
	 private String fplx;//发票类型
	 private Integer id_table;//发票id
	 
	 
	 
	
	public Integer getId_table() {
		return id_table;
	}
	public void setId_table(Integer id_table) {
		this.id_table = id_table;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFplx() {
		return fplx;
	}
	public void setFplx(String fplx) {
		this.fplx = fplx;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getZcdz() {
		return zcdz;
	}
	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}

	public String getOpen_bank() {
		return open_bank;
	}
	public void setOpen_bank(String open_bank) {
		this.open_bank = open_bank;
	}
	public String getBank_ID() {
		return bank_ID;
	}
	public void setBank_ID(String bank_ID) {
		this.bank_ID = bank_ID;
	}
	
}
