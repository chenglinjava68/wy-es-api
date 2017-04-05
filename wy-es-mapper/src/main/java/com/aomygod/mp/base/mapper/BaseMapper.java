package com.aomygod.mp.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseMapper<T> {
	@DeleteProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int deleteByIDS(@Param("ids") Object[] key);

	@SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	List<T> select(T record);

	@SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int selectCount(T record);

	@SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	T selectByPrimaryKey(Object key);

	@InsertProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int insert(T record);

	@InsertProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int insertSelective(T record);

	@DeleteProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int delete(T record);

	@DeleteProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int deleteByPrimaryKey(Object key);

	@UpdateProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int updateByPrimaryKey(T record);

	@UpdateProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int updateByPrimaryKeySelective(T record);

	@SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int selectCountByExample(Object example);

	@DeleteProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int deleteByExample(Object example);

	@SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	List<T> selectByExample(Object example);

	@UpdateProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int updateByExampleSelective(@Param("record") T record,
			@Param("example") Object example);

	@UpdateProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	int updateByExample(@Param("record") T record,
			@Param("example") Object example);



}