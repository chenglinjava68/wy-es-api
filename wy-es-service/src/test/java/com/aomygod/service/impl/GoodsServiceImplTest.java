package com.aomygod.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aomygod.es.entity.Goods;
import com.aomygod.es.repository.GoodsRepository;
import com.aomygod.es.service.GoodsService;
import com.aomygod.es.service.impl.BaseServiceImple;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/elasticsearch.xml")
public class GoodsServiceImplTest extends BaseServiceImple<Goods, Long>
		implements GoodsService {
	GoodsRepository repository;

	@Autowired
	public void setRepository(GoodsRepository repository) {
		this.repository = repository;
		super.setRepository(repository);
	}

	@Test
	public void testName() throws Exception {
		System.out.println(repository);
		System.out.println(elasticsearchTemplate);
		System.out.println(super.repository);
		Goods goods = new Goods();
		goods.setId(1L);
		goods.setVersion(1L);
		goods.setName("张三");
		goods.setKeyWord("好商品嘿嘿");
		insert(goods);
	}

}
