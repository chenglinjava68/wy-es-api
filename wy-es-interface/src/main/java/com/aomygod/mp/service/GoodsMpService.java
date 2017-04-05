package com.aomygod.mp.service;

import com.aomygod.mp.entity.Goods;
import com.github.pagehelper.PageInfo;

public interface GoodsMpService extends BaseService<Goods> {
	public PageInfo<Goods> queryContentList(Integer page, Integer rows);
}
