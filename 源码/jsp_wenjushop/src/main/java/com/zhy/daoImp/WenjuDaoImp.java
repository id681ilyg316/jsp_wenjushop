package com.zhy.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhy.beans.Wenju;
import com.zhy.dao.WenjuDao;
import com.zhy.tools.DBUtil;

public class WenjuDaoImp implements WenjuDao {

	@Override
	public List<Wenju> getAllWenjus() {
		List<Wenju> wenjus = new ArrayList<>();
		Wenju wenju = null;
		String sql = "select * from wenju";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				wenju = new Wenju(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),
						resultSet.getString(8));
				wenjus.add(wenju);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(resultSet, preparedStatement, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wenjus;
	}

	@Override
	public Wenju getWenjuById(int id) throws SQLException {
		Wenju wenju = null;

		Connection connection = DBUtil.getConnection();
		String sql = "SELECT * from wenju where id='" + id + "'";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				wenju = new Wenju(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),
						resultSet.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(resultSet, preparedStatement, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return wenju;
	}

	@Override
	public List<Wenju> getWenjusByName(String name) {
		List<Wenju> wenjus = new ArrayList<Wenju>();
		ResultSet resultSet = null;
		Connection conn = null;
		PreparedStatement ps = null;
		Wenju wenju = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from wenju where name like ?");
			ps.setString(1, "%" + name + "%");
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				wenju = new Wenju(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),
						resultSet.getString(8));
				wenjus.add(wenju);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(resultSet, ps, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wenjus;
	}

	@Override
	public void deleteWenju(int id) {
		PreparedStatement prep = null;
		Connection conn = null;
		String url = "delete from wenju  where id=?";
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(url);
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(prep, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void addWenju(Wenju wenju) {
		String sql = "insert wenju (name, author, price, introduction, stock, category, cover,time)" + "value(?, ?, ?, ?, ?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String name = wenju.getName();
		String author = wenju.getAuthor();
		int price = wenju.getPrice();
		String intro = wenju.getIntroduction();
		int stock = wenju.getStock();
		String category = wenju.getCategory();
		String cover = wenju.getCover();
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setString(4, intro);
			preparedStatement.setString(6, category);
			preparedStatement.setString(7, cover);
			preparedStatement.setDate(8, wenju.getTime());
			preparedStatement.setInt(3, price);
			preparedStatement.setInt(5, stock);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(preparedStatement, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void updateWenju(Wenju wenju) {
		int id = wenju.getId();
		String name = wenju.getName();
		String author = wenju.getAuthor();
		int price = wenju.getPrice();
		String intro = wenju.getIntroduction();
		int stock = wenju.getStock();
		String category = wenju.getCategory();
		String cover = wenju.getCover();
		
		String sql = "update wenju set name = ?, author = ?, price = ?, introduction = ?, stock = ?, category = ?, cover = ? where id = ? ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setString(4, intro);
			preparedStatement.setString(6, category);
			preparedStatement.setString(7, cover);
			preparedStatement.setInt(3, price);
			preparedStatement.setInt(5, stock);
			preparedStatement.setInt(8, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(preparedStatement, connection);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
//		Wenju wenju = new Wenju(89, "1", "1", 1, "1", 1, "小说", "1");
//		WenjuDao wenjuDao = DaoFactory.getWenjuDao();
////		wenjuDao.addWenju(wenju);
//		wenju.setName("2");
//		wenjuDao.updateWenju(wenju);
	}

	@Override
	public List<Wenju> getAllNewWenjus() {
		List<Wenju> wenjus = new ArrayList<>();
		Wenju wenju = null;
		String sql = "select * from wenju ORDER BY TIME DESC  limit 0,8 ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				wenju = new Wenju(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),
						resultSet.getString(8));
				wenjus.add(wenju);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(resultSet, preparedStatement, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wenjus;
 	}

	@Override
	public List<Wenju> getAllHotWenjus() {
		
		List<Wenju> wenjus = new ArrayList<>();
		String sql = "select wenjuid AS a,COUNT(wenjuid) AS b from orders group BY wenjuid  order BY b desc LIMIT 0,8";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int wenjuid = resultSet.getInt(1);
				Wenju wenju = getWenjuById(wenjuid);
				if(wenju != null) {
					wenjus.add(wenju);
				}
				
 			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(resultSet, preparedStatement, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wenjus;
	}

	@Override
	public List<Wenju> getAllReleativeWenjus(String cate) {
		List<Wenju> wenjus = new ArrayList<>();
		Wenju wenju = null;
		String sql = "select * from wenju where category = '"+cate+"' ORDER BY TIME DESC  limit 0,8 ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				wenju = new Wenju(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),
						resultSet.getString(8));
				wenjus.add(wenju);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(resultSet, preparedStatement, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wenjus;
	}
}
