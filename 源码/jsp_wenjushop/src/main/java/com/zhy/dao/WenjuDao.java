package com.zhy.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhy.beans.Wenju;

public interface WenjuDao {
	
	/**
	 * 获取数据库中所有文具
	 * @return
	 */
	public List<Wenju> getAllWenjus();
	
	/**
	 * 获取数据库中最新的8本文具
	 * @return
	 */
	public List<Wenju> getAllNewWenjus();
	/**
	 * 获取数据库中同类的8本文具
	 * @return
	 */
	public List<Wenju> getAllReleativeWenjus(String cate);
	
	/**
	 * 获取数据库中最热的8本文具
	 * @return
	 */
	public List<Wenju> getAllHotWenjus();
	
	/**
	 * 根据wenju的id查询wenju
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Wenju getWenjuById(int id) throws SQLException;
	
	/**
	 * 根据书名模糊查询文具
	 * @param name
	 * @return
	 */
	public List<Wenju> getWenjusByName(String name);
	
	/**
	 * 根据文具ID删除文具
	 * @param id
	 */
	public void deleteWenju(int id);
	
	/**
	 * 增加新的文具
	 * @param wenju
	 */
	public void addWenju(Wenju wenju);
	
	/**
	 * 修改文具信息
	 * @param wenju
	 */
	public void updateWenju(Wenju wenju);
	
}
