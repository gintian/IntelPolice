package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Code;
import com.model.bean.ArchiveStoresBean;
import com.model.bean.CodeBean;
import com.page.PageBean;
import com.service.CodeService;
import com.service.mapper.CodeBeanMapper;
import com.utils.CommonValidate;
import com.utils.RandomUtils;
import com.utils.ServiceUtils;
import com.utils.SysCodeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tl on 2018/5/19 0019.
 */
@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeBeanMapper codeBeanMapper;

    @Override
    public String addBean(CodeBean codeBean) throws WebMessageException {
        if (codeBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
//        // 添加主键值,, 临时使用uuid,截取20 位
//        codeBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(codeBean);
        Code code = new Code();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(code, codeBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        codeBeanMapper.insertSelective(codeBean);
        return codeBean.getId();
    }

    @Override
    public void doCacheCode(){
        SysCodeVo.clearCache();
        //缓存菜单
        SysCodeVo.setSysCodeBeanList(codeBeanMapper.findAll());
        System.out.println("字典缓存成功！");
    }

    @Override
    public void updateBean(String id, CodeBean codeBean) throws WebMessageException {
        if (codeBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(codeBean);
        Code code = new Code();
        try {
            ServiceUtils.copyProperties(code, codeBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        codeBeanMapper.updateByPrimaryKeySelective(codeBean);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        codeBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CodeBean findCodeById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        Code code = codeBeanMapper.selectByPrimaryKey(id);
        if (code != null) {
            CodeBean codeBean = new CodeBean();
            try {
                ServiceUtils.copyProperties(codeBean, code);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return codeBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<CodeBean> pageBean, CodeBean bean){
        int total = codeBeanMapper.selectTotal(bean);
        List<CodeBean> codeBeanList = new ArrayList<CodeBean>();
        if (total > 0) {
            codeBeanList = codeBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(codeBeanList);
    }

    @Override
    public List<CodeBean> findBeanListByField(String field) throws WebMessageException {
        if (CommonValidate.isEmpty(field)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        return codeBeanMapper.findBeanListByField(field);
    }

    @Override
    public List<CodeBean> findAll(){
        return codeBeanMapper.findAll();
    }

    /**
     * 校验 bean 对象
     *
     * @param
     * @throws Exception
     *             校验异常
     */

    private void validateBean(CodeBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}
