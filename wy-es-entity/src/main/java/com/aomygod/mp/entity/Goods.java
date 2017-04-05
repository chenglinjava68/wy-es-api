package com.aomygod.mp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "gc_goods")
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goods_id")
	private Long goods_id; // 商品id
	private Long spu_id;
	private Long shop_id;
	private Long type_id;
	private Long backcat_id;
	private Long brand_id;
	private String goods_name;
	private String bn;// 商品编号
	private Integer cost;// 成本价
	private Integer mktprice; // 市场价
	private Integer sale_price; // 销售价格
	private BigDecimal weight;
	private String unit;
	private String bref; // 商品简介
	private Long goods_image;// 商品主图
	private Boolean is_virtual;// 是否是虚拟商品
	private String pc_goods_info; // pc商品详情
	private String mobile_goods_info; // 移动商品详情
	private String goods_ad; // 商品广告
	private Boolean marketable; // 是否上架
	private String unmarketable_reason;
	private Integer goods_status; // 商品状态goods_status 1不通过 2待审核 3通过
	private Timestamp listing_time; // 上架时间
	private String props_text; // 商品属性序列化
	private String props_detail_text;// 详细属性序列化
	private String spec_text; // 规格序列化
	private Boolean disabled;
	private Timestamp created;// 创建时间
	private Timestamp modified;
	private String remark; // 字符串扩展字段
	private String reserved; // 数字扩展字段
	private Integer shop_type; // 店铺类型1:第三方供应商店铺 2：步步高门店店铺 3：自营
	private String barcode; // 条形码
	private String supply_code;

}
