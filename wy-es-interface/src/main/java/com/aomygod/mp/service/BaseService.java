package com.aomygod.mp.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {

	public T queryById(Long id);

	public List<T> queryList(T t);

	public PageInfo<T> queryListPage(T t, Integer page, Integer rows);

	public Integer queryCount(T t);

	public Integer save(T t);

	/**
	 * 不为null作为参数插入 判断参数是否为null
	 * 
	 * @p aram t
	 * @return
	 */
	public Integer saveSelective(T t);

	public Integer update(T t);

	/**
	 * 不为null作为参数插入
	 * 
	 * @p aram t
	 * @return
	 */
	public Integer updateSelective(T t);

	public Integer delete(Long id);

	public Integer deleteByIds(Long[] ids);
}
