package com.sybinal.shop.service.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.mapper.OptionMapper;
import com.sybinal.shop.mapper.OptionValueMapper;
import com.sybinal.shop.mapper.ProductMapper;
import com.sybinal.shop.mapper.SkuMapper;
import com.sybinal.shop.model.Option;
import com.sybinal.shop.model.OptionExample;
import com.sybinal.shop.model.OptionRelation;
import com.sybinal.shop.model.OptionValue;
import com.sybinal.shop.model.Product;
import com.sybinal.shop.model.ProductExample;
import com.sybinal.shop.model.ProductExample.Criteria;
import com.sybinal.shop.model.Sku;
import com.sybinal.shop.model.SkuExample;
import com.sybinal.shop.model.SkuVOInfo;
import com.sybinal.shop.utils.PagingTool;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	OptionValueMapper optionValueMapper;

	@Autowired
	OptionMapper optionMapper;

	@Autowired
	SkuMapper skuMapper;

	@Autowired
	PagingTool pagingTool;

	@Autowired
	ProductMapper productMapper;


	@Override
	public List<Option> getOption() {
		return optionMapper.selectByExample(null);
	}

	@Override
	public Option getOption(int optionId) {
		return optionMapper.selectByPrimaryKey(optionId);
	}


	@Override
	public List<SkuVOInfo> getOptionByOptionId(List<Integer> idList) {
		OptionExample example = new OptionExample();
		example.setOrderByClause("`oi`.`id`, `ov`.`id`");
		OptionExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(idList);
		List<OptionRelation> optionList = optionMapper.selectOptionRelationById(example);
		List<SkuVOInfo> list = new ArrayList<SkuVOInfo>();
		return skuTraverse(list, optionList);
	}
	
	private List<SkuVOInfo> skuTraverse(List<SkuVOInfo> list, List<OptionRelation> optionList) {
		if (optionList.size() == 0)
			return list;
		List<SkuVOInfo> template = skuTemplate(optionList.get(0));
		if (optionList.size() == 2) {
			for (SkuVOInfo skuVOInfo : template)
				for (OptionValue optionValue : optionList.get(1).getOptionValuesList()) {
					SkuVOInfo info = new SkuVOInfo();
					info.setKey(String.format("%s_%s", skuVOInfo.getKey(), optionValue.getId()));
					info.setTitleName(String.format("%s%s:%s ", skuVOInfo.getTitleName(), optionList.get(1).getName(), optionValue.getName()));
					list.add(info);
				}
			return list;
		}
		return template;
	}
	
	private List<SkuVOInfo> skuTemplate(OptionRelation optionList) {
		List<SkuVOInfo> list = new ArrayList<SkuVOInfo>();
		for (OptionValue value : optionList.getOptionValuesList()) {
			SkuVOInfo info = new SkuVOInfo();
			info.setKey(String.valueOf(value.getId()));
			info.setTitleName(String.format("%s:%s ", optionList.getName(), value.getName()));
			list.add(info);
		}
		return list;
	}

}
