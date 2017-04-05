package com.aomygod.es.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends
		ElasticsearchRepository<T, ID> {

	@Query("{\"bool\" : {\"must\" : {\"field\" : {\"name\" : \"?0\"}}}}")
	Page<T> findByName(String name, Pageable pageable);

	@Query("{\"bool\" : {\"must\" : {\"field\" : {\"keyWord\" : \"?0\"}}}}")
	Page<T> findBykeyWord(String keyWord, Pageable pageable);

	
}
