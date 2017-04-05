package com.aomygod.mp.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aomygod.mp.entity.Goods;
import com.aomygod.mp.service.GoodsMpService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/goods-mp")
public class GoodsMpController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "goodsMpService")
	private GoodsMpService goodsMpService;

	@RequestMapping(value = "/add/{page}/{rows}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PageInfo<Goods>> queryContent(
			@PathVariable("page") Integer page,
			@PathVariable("rows") Integer rows) {
		logger.info("查询");
		PageInfo<Goods> pageInfo = this.goodsMpService.queryContentList(page,
				rows);
		logger.info(pageInfo.getList().size()+"");
		return ResponseEntity.ok(pageInfo);
	}

}
