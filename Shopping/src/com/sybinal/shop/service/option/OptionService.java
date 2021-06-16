package com.sybinal.shop.service.option;

import java.util.List;
import java.util.Map;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.model.Option;
import com.sybinal.shop.model.OptionRelation;
import com.sybinal.shop.model.Sku;
import com.sybinal.shop.model.SkuVOInfo;

/**
 * Option service
 * 
 * @author erase_leo
 *
 */
public interface OptionService {
	


	List<Option> getOption();

	Option getOption(int optionId);

	
	List<SkuVOInfo> getOptionByOptionId(List<Integer> idList);
}
