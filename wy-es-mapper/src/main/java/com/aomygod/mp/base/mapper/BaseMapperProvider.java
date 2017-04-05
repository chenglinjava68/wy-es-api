package com.aomygod.mp.base.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.scripting.xmltags.MixedSqlNode;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

import com.github.abel533.mapper.MapperProvider;
import com.github.abel533.mapperhelper.EntityHelper;
import com.github.abel533.mapperhelper.MapperHelper;

public class BaseMapperProvider extends MapperProvider {

	public BaseMapperProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	/**
	 * 通过ids批量删除
	 * 
	 * @param ms
	 * @return
	 */
	public SqlNode deleteByIDS(MappedStatement ms) {
		Class<?> entityClass = getSelectReturnType(ms);
		Set<EntityHelper.EntityColumn> entityColumns = EntityHelper
				.getPKColumns(entityClass);
		EntityHelper.EntityColumn entityColumn = null;
		for (EntityHelper.EntityColumn entity : entityColumns) {
			entityColumn = entity;
			break;
		}
		EntityHelper.EntityColumn column = entityColumn;
		List<SqlNode> sqlNodes = new ArrayList<SqlNode>();

		BEGIN();
		DELETE_FROM(tableName(entityClass));
		String sql = SQL();
		sqlNodes.add(new StaticTextSqlNode(sql + " WHERE " + column.getColumn()
				+ " IN "));
		SqlNode foreach = new ForEachSqlNode(ms.getConfiguration(),
				new StaticTextSqlNode("#{" + column.getProperty() + "}"),
				"ids", "index", column.getProperty(), "(", ")", ",");
		sqlNodes.add(foreach);
		return new MixedSqlNode(sqlNodes);

	}

}
