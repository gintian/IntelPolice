package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页查询返回对象：
 * 
 * @author OnJuly
 *
 */
public class PageList<T> {
	private int total = 0;// 总的条数

	// 这个地方应该new出来，那样即使查询出没有数据，返回的也是一个空的对象，而不是null
	private List<T> rows = new ArrayList<T>();

	public PageList() {
	}
	public PageList(int total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageList [total=" + total + ", rows=" + rows + "]";
	}
}
