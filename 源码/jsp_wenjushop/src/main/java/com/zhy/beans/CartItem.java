package com.zhy.beans;

import java.math.BigDecimal;

public class CartItem {

	private Wenju wenju;
	private int quantity;

	/**
	 * 小计方法：处理二进制运算误差问题
	 * @return
	 */
	public double getSubtotalPrice(){  //计算方法，没有对应成员
		
		//将double转化为BigDecimal类型：解决二进制运算误差问题
		BigDecimal _price = BigDecimal.valueOf(wenju.getPrice());
		BigDecimal _count = BigDecimal.valueOf(quantity);
		
		//计算价格（价钱*数量）,并转回double类型
		return _price.multiply(_count).doubleValue();  
	}


	public Wenju getWenju() {
		return wenju;
	}

	public void setWenju(Wenju wenju) {
		this.wenju = wenju;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}