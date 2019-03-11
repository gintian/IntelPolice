package com.service;

import com.exception.WebMessageException;
import com.model.ViewDoc;
import com.model.bean.JJBean;
import com.model.bean.ViewDocBean;
import com.page.PageBean;

import java.util.List;

public interface ViewDocService {

    public List<ViewDocBean> showAllView();

    public void pageQuery(PageBean<ViewDocBean> pageBean, ViewDocBean bean);

    public void selectNoCorrelateView(PageBean<ViewDocBean> pageBean, ViewDocBean bean);

    public void viewCorrelate(ViewDocBean viewDocBean, String jjdbh, String cjdbh, String caseid);

    public ViewDocBean findViewByDocid(String docId);

    public void selectDocIdByOther(PageBean<ViewDocBean> pageBean, ViewDocBean bean,String jjdbh, String cjdbh, String caseid);

}
