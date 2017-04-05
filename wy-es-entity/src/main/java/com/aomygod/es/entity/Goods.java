package com.aomygod.es.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "aomygod", type = "amg_business_goods")
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name; // 商品名称
	private String shopId;// 店铺ID
	private String shopName; // 店铺名称
	private double price;// 商品价格
	private double promotionPrice; // 促销价
	private String sellingPoint;// 销售卖点
	private String imgUrl; // 图片地址
	@Field(type = FieldType.String, searchAnalyzer = "analysis-ik", store = true)
	private String keyWord; // 搜索key
	@Version
	private Long version;// 版本号,不能一致

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", shopId=" + shopId
				+ ", shopName=" + shopName + ", price=" + price
				+ ", promotionPrice=" + promotionPrice + ", sellingPoint="
				+ sellingPoint + ", imgUrl=" + imgUrl + ", keyWord=" + keyWord
				+ ", version=" + version + "]";
	}

}
