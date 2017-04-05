package com.aomygod.es.service.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import com.aomygod.es.repository.BaseRepository;
import com.aomygod.es.service.BaseService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseServiceImple<T, ID extends Serializable> implements
		BaseService<T, ID> {
	protected BaseRepository repository;

	@Resource
	protected ElasticsearchTemplate elasticsearchTemplate;

	public void setRepository(BaseRepository repository) {
		this.repository = repository;
	}

	public void indexMapperEntity(Class<T> clazz) {
		elasticsearchTemplate.putMapping(clazz);
	}

	public void refreshIndex(Class<T> clazz) {
		elasticsearchTemplate.refresh(clazz);
	}

	public void createIndex(Class<T> clazz) {
		elasticsearchTemplate.createIndex(clazz);
	}

	public void deleteIndex(Class<T> clazz) {
		elasticsearchTemplate.deleteIndex(clazz);
	}

	public void insert(T Object) {
		repository.save(Object);
	}

	public void batchInsert(Iterable<T> iterator) {
		repository.save(iterator);
	}

	public void delete(T Object) {
		repository.delete(Object);
	}

	public void deleteById(Serializable id) {
		repository.delete(id);
	}

	public void batchDelete(Iterable<T> iterator) {
		repository.delete(iterator);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public boolean existById(Serializable id) {
		return repository.exists(id);
	}

	public Long count() {
		return repository.count();
	}

	public Iterator<T> findAll() {
		return repository.findAll().iterator();
	}

	public Iterator<T> findAll(Pageable pageable) {
		return repository.findAll(pageable).iterator();
	}

	public Iterator<T> findAll(Sort sort) {
		return repository.findAll(sort).iterator();
	}

	public Iterator<T> findByIds(Iterable<String> ids) {
		return repository.findAll(ids).iterator();
	}

	public T findById(Serializable id) {
		return (T) repository.findOne(id);
	}

	public Iterator<T> queryByName(String name, Pageable pageable) {
		return repository.findByName(name, pageable).iterator();
	}

	public Iterator<T> queryBykeyWord(String keyword, Pageable pageable) {
		return repository.findBykeyWord(keyword, pageable).iterator();
	}

}
