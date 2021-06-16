package com.sybinal.shop.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.mapper.AccountMapper;
import com.sybinal.shop.model.Account;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountMapper accountMapper;
	
	@Override
	@Transactional
	public int insertAccountRecord(Account account) {
		// TODO Auto-generated method stub
		return accountMapper.insertAccountRecord(account);
	}

	@Override
	@Transactional
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountMapper.updateAccount(account);
	}

	
	@Override
	public List<Account> getAccountRecord(String username) {
		// TODO Auto-generated method stub
		return accountMapper.selectAccountRecord(username);
	}

	@Override
	public List<Account> getAccountRecords(Account username) {
		// TODO Auto-generated method stub
		return accountMapper.selectAccountRecords(username);
	}

}
