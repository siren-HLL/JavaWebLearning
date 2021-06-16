package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.Account;

public interface AccountMapper {
		//新增充值流水
		int insertAccountRecord(Account account);
		//充值
		void updateAccount(Account account);
		//查询过往流水
		List<Account> selectAccountRecord(String username);
		List<Account> selectAccountRecords(Account username);
}
