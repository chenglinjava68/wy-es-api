package com.aomygod.es.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aomygod.es.entity.Goods;
import com.aomygod.es.service.GoodsService;

@Controller
@RequestMapping(value = "/goods-es")
public class GoodsController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ResponseEntity<Map<String, Object>> add() {
		Goods goods = new Goods();
		goods.setId(1L);
		goods.setImgUrl("a");
		goods.setKeyWord("keyWord");
		goods.setName("name");
		goods.setShopId("shopId");
		goods.setShopName("shopName");
		goods.setVersion(1L);
		logger.info(goods.toString());
		goodsService.insert(goods);
		return null;
	}
	
}
