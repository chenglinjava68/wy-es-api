package com.aomygod.es.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aomygod.es.entity.Goods;
import com.aomygod.es.repository.GoodsRepository;
import com.aomygod.es.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImple<Goods, Long> implements
		GoodsService {
	GoodsRepository repository;

	
	@Autowired
	public void setRepository(GoodsRepository repository) {
		this.repository = repository;
		super.setRepository(repository);
	}

}
