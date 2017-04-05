package com.aomygod.mp.mapper;

import java.util.List;

import com.aomygod.mp.base.mapper.BaseMapper;
import com.aomygod.mp.entity.Goods;

public interface GoodsMapper extends BaseMapper<Goods> {
	List<Goods> queryGoodsList();
}
