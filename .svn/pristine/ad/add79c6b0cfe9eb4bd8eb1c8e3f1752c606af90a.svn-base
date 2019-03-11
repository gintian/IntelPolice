package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;

import com.model.bean.ViewDocBean;

import com.page.PageBean;
import com.service.ViewDocService;
import com.service.mapper.ViewDocBeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("viewDocService")
public class ViewDocServiceImpl implements ViewDocService {

    @Autowired
    private ViewDocBeanMapper viewDocBeanMapper;

    //查询所有音视频
    public List<ViewDocBean> showAllView() {
        System.out.println("ViewDocServiceImpl");

        return viewDocBeanMapper.showAllView();
    }


    //分页显示所有音视频
    @Override
    public void pageQuery(PageBean<ViewDocBean> pageBean, ViewDocBean bean) {

        int total = viewDocBeanMapper.countTotal(bean);
        List<ViewDocBean> list = viewDocBeanMapper.selectBeanPage(pageBean, bean);
//        List<ViewDocBean> list = viewDocBeanMapper.showAllView();

        System.out.println(list);

        pageBean.setTotal(total);
        pageBean.setRows(list);
    }

    //查询没有关联的音视频
    @Override
    public void selectNoCorrelateView(PageBean<ViewDocBean> pageBean, ViewDocBean bean) {

        int noCorrelateViewTotal = viewDocBeanMapper.countTotal(null) - viewDocBeanMapper.selectCorrelateViewTotal();

        List<ViewDocBean> list = viewDocBeanMapper.selectNoCorrelateView(pageBean, bean);

        pageBean.setTotal(noCorrelateViewTotal);

        pageBean.setRows(list);

    }

    //音视频关联提交
    @Override
    public void viewCorrelate(ViewDocBean viewDocBean, String jjdbh, String cjdbh, String caseid) {
        String id = UUID.randomUUID().toString();
        viewDocBeanMapper.viewCorrelate(id, viewDocBean, jjdbh, cjdbh, caseid);
    }

    //通过音视频docid查找
    @Override
    public ViewDocBean findViewByDocid(String id) {
        return viewDocBeanMapper.findViewByDocid(id);
    }

    //通过jjdbh、cjdbh、caseid查找音视频
    @Override
    public void selectDocIdByOther(PageBean<ViewDocBean> pageBean, ViewDocBean bean, String jjdbh, String cjdbh, String caseid) {


        System.out.println("*********");
        System.out.println(jjdbh);
        System.out.println(cjdbh);
        System.out.println(caseid);
        System.out.println("*********");

        int total = viewDocBeanMapper.selectViewTotalByOther(pageBean, bean, jjdbh, cjdbh, caseid);



        List<ViewDocBean> list = viewDocBeanMapper.selectViewByOther(pageBean, bean, jjdbh, cjdbh, caseid);

        pageBean.setTotal(total);
        pageBean.setRows(list);


    }


    public void updateBean(String id, ViewDocBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.MEDIA_ID_IS_NONE);
        }
        if (bean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
    }


}
