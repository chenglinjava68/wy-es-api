package com.aomygod.mp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aomygod.mp.entity.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("goodsMpService")
public class GoodsMpServiceImpl extends BaseServiceImpl<Goods> implements
		GoodsMpService {
	public PageInfo<Goods> queryContentList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows); 
		List<Goods> list = goodsMapper.queryGoodsList();
		System.out.println(list.size());
		return new PageInfo<Goods>(list);
	}

}
