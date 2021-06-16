package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.FaPiao;

public interface FaPiaoMapper {
	int insertFaPiao(FaPiao fapiao);
	
	List<FaPiao> getFapiaoInfo();
	
	int updateFapiaoByTableId(FaPiao faPiao);
	
	int deleteFapiaoByPrimarykey(FaPiao id_table);
}
