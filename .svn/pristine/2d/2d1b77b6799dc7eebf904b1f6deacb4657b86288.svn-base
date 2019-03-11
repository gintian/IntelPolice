package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Criminal;
import com.model.Files;
import com.model.bean.CriminalBean;
import com.model.bean.FilesBean;
import com.page.PageBean;
import com.service.FilesService;
import com.service.mapper.FilesBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：FilesServiceImpl 类描述：留言操作业务逻辑接口实现
 */
@Service("filesService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class FilesServiceImpl implements FilesService {
    @Autowired
    private FilesBeanMapper filesBeanMapper;

    @Override
    public void addBean(FilesBean filesBean) throws WebMessageException {
        if (filesBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        filesBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(filesBean);
        Files files = new Files();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(files, filesBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        filesBeanMapper.insertSelective(filesBean);
    }

    @Override
    public void updateBean(String id, FilesBean filesBean) throws WebMessageException {
        if (filesBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(filesBean);
        Files files = new Files();
        try {
            ServiceUtils.copyProperties(files, filesBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        filesBeanMapper.updateByPrimaryKeySelective(files);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        filesBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public FilesBean findFilesById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        Files files = filesBeanMapper.selectByPrimaryKey(id);
        if (files != null) {
            FilesBean filesBean = new FilesBean();
            try {
                ServiceUtils.copyProperties(filesBean, files);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return filesBean;
        }
        return null;
    }

    @Override
    public void setEnable(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        Files files = filesBeanMapper.selectByPrimaryKey(id);
        String status = files.getStatus();
        if (status.equals("1")) {
            files.setStatus("2");
            filesBeanMapper.updateByPrimaryKeySelective(files);
        } else {
            files.setStatus("1");
            filesBeanMapper.updateByPrimaryKeySelective(files);
        }
    }

    @Override
    public void pageQuery(PageBean<Files> pageBean, FilesBean bean) {
        int total = filesBeanMapper.selectTotal(bean);
        List<FilesBean> filesBeanList = new ArrayList<FilesBean>();
        if (total > 0) {
            filesBeanList = filesBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(filesBeanList);
    }

    /**
     * 各个模块查询案件信息的公共方法
     *
     * @param pageBean
     * @param bean
     * @param moduleFunction 模块功能,如"未录入笔录的案件"
     * @throws WebMessageException
     */
    public void findBeanPageForModule(PageBean<Files> pageBean, FilesBean bean, String moduleFunction) throws WebMessageException {
        int total = filesBeanMapper.findBeanPageForModuleTotal(bean,moduleFunction);
        List<FilesBean> filesBeanList = new ArrayList<FilesBean>();
        if (total > 0) {
            filesBeanList = filesBeanMapper.findBeanPageForModule(pageBean, bean, moduleFunction);
        }
        pageBean.setTotal(total);
        pageBean.setRows(filesBeanList);
    }

    /**
     * 校验 bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(FilesBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}
