package com.page;

import java.util.List;

public class PageBean<T> {
    public static final int PAGESIZE = 200;   //每页默认大小
	private int page=1;            //当前页码
    private int pageSize = PAGESIZE;       //每页显示记录数
    private int total;//总记录数
    private List rows;//当前页需要展示的数据集合
    //orcle ,sql 分页专用，请谨慎修改
    private int pageCount;
    private int pageNum;

    public int getPageCount() {
        return page * pageSize;
    }

    public int getPageNum() {
        return (page - 1) * pageSize;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
}
