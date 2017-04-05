package com.aomygod.mp.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.aomygod.mp.base.mapper.BaseMapper;
import com.aomygod.mp.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	protected GoodsMapper goodsMapper;

	protected BaseMapper<T> baseMapper;

	@SuppressWarnings("rawtypes")
	@PostConstruct
	// 在构造方法后，初化前执行
	public void initBaseMapper() throws Exception {
		// 完成以下逻辑，需要对研发本身进行命名与使用规范
		// this关键字指对象本身，这里指的是调用此方法的实现类（子类）
		System.out.println("=======this :" + this);
		System.out.println("=======父类基本信息：" + this.getClass().getSuperclass());
		System.out.println("=======父类和泛型的信息："
				+ this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// 获取第一个参数的class
		Class clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println("=======class:" + clazz);
		// 转化为属性名（相关的Mapper子类的引用名）Supplier supplierMapper
		String localField = clazz.getSimpleName().substring(0, 1).toLowerCase()
				+ clazz.getSimpleName().substring(1) + "Mapper";
		System.out.println("=======localField:" + localField);
		// getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
		Field field = this.getClass().getSuperclass()
				.getDeclaredField(localField);
		System.out.println("=======field:" + field);
		System.out.println("=======field对应的对象:" + field.get(this));
		Field baseField = this.getClass().getSuperclass()
				.getDeclaredField("baseMapper");

		System.out.println("=======baseField:" + baseField);
		System.out.println("=======baseField对应的对象:" + baseField.get(this));
		// field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中
		baseField.set(this, field.get(this));
		System.out.println("========baseField对应的对象:" + baseMapper);

	}

	public T queryById(Long id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	public List<T> queryList(T t) {
		return baseMapper.select(t);
	}

	public PageInfo<T> queryListPage(T t, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<T> list = this.queryList(t);
		return new PageInfo<T>(list);
	}

	public Integer queryCount(T t) {
		return baseMapper.selectCount(t);
	}

	public Integer save(T t) {
		return baseMapper.insert(t);
	}

	public Integer saveSelective(T t) {
		return baseMapper.insertSelective(t);
	}

	public Integer update(T t) {
		return baseMapper.updateByPrimaryKey(t);
	}

	public Integer updateSelective(T t) {
		return baseMapper.updateByPrimaryKeySelective(t);
	}

	public Integer delete(Long id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	public Integer deleteByIds(Long[] ids) {
		return baseMapper.deleteByIDS(ids);
	}
}
