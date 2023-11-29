package com.zhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhy.beans.Wenju;
import com.zhy.beans.Category;
import com.zhy.dao.CategoryDao;
import com.zhy.factory.DaoFactory;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, SQLException {
		/*
		 * 1.获取到分类名 2.查询到该分类下所有文具 3.将所有文具放入wenjus集合 4.将wenjus集合放入request的属性
		 * 5.重定向到显示该分类所有文具的页面
		 */
		int size = 9;
		int page = 1;
		String categoryId = request.getParameter("id");
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		List<Wenju> wenjus = new ArrayList<>();
		wenjus = DaoFactory.getCategoryDao().getWenjusByCategoryId(Integer.parseInt(categoryId));
		int pagesize = getPageSize(wenjus, size);
		wenjus = getList(wenjus, page, size);
		if(page<=0) {
			page = 1;
		}
		if(page>=pagesize) {
			page = pagesize;
		}
		request.setAttribute("category", wenjus);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("nowpage", page);
		request.setAttribute("cateid", categoryId);
		request.getRequestDispatcher("/shop.jsp").forward(request, response);

	}
	
	public void getAllwenjus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, SQLException {
		/*
		 * 1.获取到分类名 2.查询到该分类下所有文具 3.将所有文具放入wenjus集合 4.将wenjus集合放入request的属性
		 * 5.重定向到显示该分类所有文具的页面
		 */
		int size = 8;
		int page = 1;
 		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		List<Wenju> wenjus = new ArrayList<>();
		wenjus = DaoFactory.getWenjuDao().getAllWenjus();
		int pagesize = getPageSize(wenjus, size);
		wenjus = getList(wenjus, page, size);
		if(page<=0) {
			page = 1;
		}
		if(page>=pagesize) {
			page = pagesize;
		}
		request.setAttribute("category", wenjus);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("nowpage", page);
 		request.getRequestDispatcher("/allwenjus.jsp").forward(request, response);

	}
	
	static List<Wenju> getList(List<Wenju> list,int page,int size){
		int end = 0;
		int pages = list.size()/size + 1;
		if(page>pages) {
			page = pages - 1;
		}
		if(page < 1) {
			page = 1;
		}
		if(page*size>list.size()) {
			end = list.size();
		}else {
			end = page*size;
		}
		
		return list.subList((page-1)*size, end);
	}
	
	static int getPageSize(List<Wenju> list,int size) {
		if(list.size() % size == 0) {
			return list.size()/size;
		}else {
			return list.size()/size + 1;
		}
	 
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, SQLException {
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		String parent = request.getParameter("parent");
		Category category = new Category(0, name, Integer.parseInt(grade), Integer.parseInt(parent));
		CategoryDao categoryDao = DaoFactory.getCategoryDao();
		try {
			categoryDao.addCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/tgls/goodsManage/goodsType_list.jsp?page=1&size=9");

	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, SQLException{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		String parent = request.getParameter("parent");

		Category category = new Category(Integer.parseInt(id), name, Integer.parseInt(grade), Integer.parseInt(parent));

		DaoFactory.getCategoryDao().updateCategory(category);
		String url = "/tgls/goodsManage/goodsType_update.jsp?id="+id;
		response.sendRedirect(request.getContextPath() + url);
	}

	
	public static void main(String[] args) {
		
	}
}
