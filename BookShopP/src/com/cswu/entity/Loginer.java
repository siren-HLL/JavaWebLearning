package com.cswu.entity;

/**
 * ��¼�û�����Ϣ
 * @author Administrator
 *
 */
public class Loginer {

	private String username;//�û���
	private String password;//����
	private String signtime;//��¼ʱ��
	
	//���� setter,getter����
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSigntime() {
		return signtime;
	}
	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}
	
}
