package com.sybinal.shop.service.account;

import java.util.List;

import com.sybinal.shop.model.Account;

public interface AccountService {
	//充值
	public int insertAccountRecord(Account account);
	//数据库账户金额变更（user表的recharge）
	public void updateAccount(Account account);
	//查询过往流水
	public List<Account> getAccountRecord(String username);
	public List<Account> getAccountRecords(Account username);
}
