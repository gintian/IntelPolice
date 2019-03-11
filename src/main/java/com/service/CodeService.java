package com.service;

import com.exception.WebMessageException;
import com.model.Code;
import com.model.bean.ArchiveStoresBean;
import com.model.bean.CodeBean;
import com.page.PageBean;

import java.util.List;

/**
 * Created by tl on 2018/5/19 0019.
 */
public interface CodeService {
    //添加
    String addBean(CodeBean codeBean) throws WebMessageException;
    //修改
    void updateBean(String id, CodeBean codeBean) throws WebMessageException;
    //删除
    void deleteBean(String id) throws WebMessageException;
    /**
     * 通过Id查询Bean
     */
    CodeBean findCodeById(String id) throws WebMessageException;
    /**
     * 条件查询：分页条件
     * @param pageBean
     * @param bean
     * @return
     */
    void pageQuery(PageBean<CodeBean> pageBean, CodeBean bean);

    List<CodeBean> findBeanListByField(String field) throws WebMessageException;

    /**
     * 查询所有
     * @return
     * @throws WebMessageException
     */
    List<CodeBean> findAll() throws WebMessageException;

    /**
     * 缓存字典
     */
    void doCacheCode();
}
