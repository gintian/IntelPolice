package com.service;

import com.exception.WebMessageException;
import com.model.Criminal;
import com.model.Files;
import com.model.bean.CriminalBean;
import com.model.bean.FilesBean;
import com.page.PageBean;

/**
 * 类名称：FilesService 类描述：公告逻辑接口
 */
public interface FilesService {
    //增加
    void addBean(FilesBean bean) throws WebMessageException;

    //修改
    void updateBean(String id, FilesBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String id) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    FilesBean findFilesById(String id) throws WebMessageException;

    /**
     *设置启用/只用作模板
     * @param id
     * @throws WebMessageException
     */
    void setEnable(String id) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<Files> pageBean, FilesBean bean);

    /**
     *
     * @param pageBean
     * @param bean
     * @param moduleFunction     模块功能,如"扣押清单模板管理"
     * @throws WebMessageException
     */
    void  findBeanPageForModule(PageBean<Files> pageBean, FilesBean bean, String moduleFunction) throws WebMessageException;
}
