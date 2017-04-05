package com.aomygod.es.service;

import java.io.Serializable;
import java.util.Iterator;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BaseService<T, ID extends Serializable> {

	/**
	 * 隐射索引库
	 * 
	 * @param clazz
	 */
	public void indexMapperEntity(Class<T> clazz);

	/**
	 * 刷新索引库
	 * 
	 * @param clazz
	 */
	public void refreshIndex(Class<T> clazz);

	/**
	 * 创建索引库
	 * 
	 * @param clazz
	 */
	public void createIndex(Class<T> clazz);

	/**
	 * 删除索引库
	 */
	public void deleteIndex(Class<T> clazz);

	/**
	 * 插入单个实体
	 * 
	 * @param book
	 */
	public void insert(T Object);

	/**
	 * 批量插入
	 * 
	 * @param iterator
	 */
	public void batchInsert(Iterable<T> iterator);

	/**
	 * 根据对象删除,对象id必须给(已测)
	 * 
	 * @param book
	 */
	public void delete(T Object);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void deleteById(ID id);

	/**
	 * 批量增加
	 * 
	 * @param iterator
	 */
	public void batchDelete(Iterable<T> iterator);

	/**
	 * 删除所有
	 */
	public void deleteAll();

	/**
	 * 根据id判断是否存在对象
	 * 
	 * @param id
	 */
	public boolean existById(ID id);

	/**
	 * 查询所有个数
	 * 
	 * @return
	 */
	public Long count();

	/******************* 查询 支持DSL ************/
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public Iterator<T> findAll();

	/**
	 * 按照分页规则查询数据
	 * 
	 * @param pageable
	 *            设置分页,以及排序规则
	 * @return
	 */
	public Iterator<T> findAll(Pageable pageable);

	/**
	 * 按照排序规则查询所有数据
	 * 
	 * @param sort
	 * @return
	 */
	public Iterator<T> findAll(Sort sort);

	/**
	 * 根据id批量查询
	 * 
	 * @param ids
	 * @return
	 */
	public Iterator<T> findByIds(Iterable<String> ids);

	/**
	 * 根据id查询单个对象
	 * 
	 * @param id
	 * @return
	 */
	public T findById(ID id);

	/**
	 * 根据name和分页规则查询数据
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Iterator<T> queryByName(String name, Pageable pageable);

	public Iterator<T> queryBykeyWord(String keyword, Pageable pageable);
}
