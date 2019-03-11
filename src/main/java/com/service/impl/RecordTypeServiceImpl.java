package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.RecordType;
import com.model.bean.RecordTypeBean;
import com.page.PageBean;
import com.service.RecordTypeService;
import com.service.mapper.RecordTypeBeanMapper;
import com.utils.CommonValidate;
import com.utils.ServiceUtils;
import com.utils.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：RecordTypeServiceImpl 类描述：涉案财物信息表操作业务逻辑接口实现
 */
@Service("recordTypeService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class RecordTypeServiceImpl implements RecordTypeService {
    @Autowired
    private RecordTypeBeanMapper recordTypeBeanMapper;

    @Override
    public List<RecordTypeBean> findMenuByParentId(String parentId) throws WebMessageException {
        if (StringUtils.isEmpty(parentId)) {
            throw new WebMessageException(WebExceptionConstant.MENU_PARENTID_IS_NONE);
        }
        return recordTypeBeanMapper.findMenuByParentId(parentId);
    }

    @Override
    public List<RecordTypeBean> findOneLevelMenuByParentId(String parentId) throws WebMessageException {
        if (CommonValidate.isEmpty(parentId)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        return recordTypeBeanMapper.findOneLevelMenuByParentId(parentId);
    }
/*有*/
    @Override
    public void addMenuBean(RecordTypeBean recordTypeBean) throws Exception {
        // 添加主键值,, 临时使用uuid,截取20 位
        recordTypeBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(recordTypeBean);
        RecordType recordType = new RecordType();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(recordType, recordTypeBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        recordTypeBeanMapper.insert(recordType);
    }
    /*有*/
    @Override
    public void updateMenuBean(String id, RecordTypeBean recordTypeBean) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.MENU_MENUID_IS_NONE);
        }
        RecordType recordType = new RecordType();
        BeanUtils.copyProperties(recordType, recordTypeBean);
        recordTypeBeanMapper.updateByPrimaryKeySelective(recordType);
    }
    /*有*/
    @Override
    public void deleteMenuBean(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.MENU_MENUID_IS_NONE);
        }
        recordTypeBeanMapper.deleteByPrimaryKey(id);
    }
    /*有*/
    @Override
    public RecordTypeBean findMenuByMenuId(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.MENU_MENUID_IS_NONE);
        }
        RecordTypeBean recordTypeBean = new RecordTypeBean();
        RecordType recordType = recordTypeBeanMapper.selectByPrimaryKey(id);
        if (recordType == null) {
            recordType = new RecordType();
            recordType.setName("--");
        }
        BeanUtils.copyProperties(recordTypeBean, recordType);
        return recordTypeBean;
    }
    /*有*/
    @Override
    public String showMenuAll(HttpServletRequest request) {
        return null;
    }
    /*有*/
    @Override
    public List<RecordTypeBean> findMenuBeanList() throws WebMessageException {
        List<RecordTypeBean> recordTypeBeanList = recordTypeBeanMapper.findAll();
        return recordTypeBeanList;
    }
    /*有*/
    @Override
    public void doCacheMenu() {

    }

    @Override
    public List<RecordTypeBean> findAllByLevel() {
        List<RecordTypeBean> recordTypeBeanList = null;
        try{
            recordTypeBeanList = recordTypeBeanMapper.findAllByLevel();
        }catch (Exception e){e.printStackTrace();}
        return recordTypeBeanList;
    }

    private org.json.JSONArray formatJsonToMenu(List<RecordTypeBean> list){
        //查询顶级菜单
        List<org.json.JSONObject> rootJson = new ArrayList<>();
        for (RecordTypeBean recordTypeBean : findByEqParentId("01", list)){
            org.json.JSONObject jsonobj = StringUtil.formatJsonObject(new org.json.JSONObject(recordTypeBean));
            List<org.json.JSONObject> list2 = new ArrayList<>();
            for (RecordTypeBean menu2 : findByEqParentId(recordTypeBean.getId(), list)){
                org.json.JSONObject jsonobj2 = StringUtil.formatJsonObject(new org.json.JSONObject(menu2));
                List<org.json.JSONObject> list3 = new ArrayList<>();
                for (RecordTypeBean menu3 : findByEqParentId(menu2.getId(), list)){
                    org.json.JSONObject jsonobj3 = StringUtil.formatJsonObject(new org.json.JSONObject(menu3));
                    list3.add(jsonobj3);
                }
                jsonobj2.put("children", list3);
                list2.add(jsonobj2);
            }
            jsonobj.put("children", list2);
            rootJson.add(jsonobj);
        }
        return new JSONArray(rootJson);
    }
    /**
     * 根据父类查询子一代类
     * @param parentId                  [必填]
     * @return
     */
    private List<RecordTypeBean> findByEqParentId(String parentId, List<RecordTypeBean> menuList_user){
        List<RecordTypeBean> resultList = new ArrayList<>();
        if (StringUtils.isEmpty(parentId)){
            return resultList;
        }
        for (RecordTypeBean deptBean : menuList_user){
            if (parentId.equals(deptBean.getParentid())){
                resultList.add(deptBean);
            }
        }
        return resultList;
    }
    private void validateBean(RecordTypeBean recordTypeBean) throws WebMessageException {
        if (recordTypeBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        if (StringUtils.isEmpty(recordTypeBean.getName())) {
            throw new WebMessageException(WebExceptionConstant.NAME_IS_NONE);
        }
        if (StringUtils.isEmpty(recordTypeBean.getParentid())) {
            throw new WebMessageException(WebExceptionConstant.MENU_PARENTID_IS_NONE);
        }
        if (StringUtils.isEmpty(recordTypeBean.getOrder())) {
            throw new WebMessageException(WebExceptionConstant.MENU_LEAF_IS_NONE);
        }
    }

  /*  @Override
    public String addBean(RecordTypeBean recordTypeBean) throws WebMessageException {
        return null;
    }

    @Override
    public void updateBean(String id, RecordTypeBean recordTypeBean) throws WebMessageException {
        if (recordTypeBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(recordTypeBean);
        RecordType recordType = new RecordType();
        try {
            ServiceUtils.copyProperties(recordType, recordTypeBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        recordTypeBeanMapper.updateByPrimaryKeySelective(recordType);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        recordTypeBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RecordTypeBean findRecordTypeById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        RecordType record = recordTypeBeanMapper.selectByPrimaryKey(id);
        if (record != null) {
            RecordTypeBean recordTypeBean = new RecordTypeBean();
            try {
                ServiceUtils.copyProperties(recordTypeBean, record);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return recordTypeBean;
        }
        return null;
    }

    @Override
    public List<RecordTypeBean> findRecordTypeByParentId(String parentId) throws WebMessageException {
        if (StringUtils.isEmpty(parentId)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        List<RecordTypeBean> list = recordTypeBeanMapper.selectByParentId(parentId);
        return list;
    }

    @Override
    public List<RecordTypeBean> findAll() throws WebMessageException {
        List<RecordTypeBean> involvedTypesBeanList = new ArrayList<RecordTypeBean>();
        // 查询对象
        involvedTypesBeanList = recordTypeBeanMapper.selectAll();
        return involvedTypesBeanList;
    }

    @Override
    public void pageQuery(PageBean<RecordTypeBean> pageBean, RecordTypeBean bean) {
        int total = recordTypeBeanMapper.selectTotal(bean);
        List<RecordTypeBean> recordTypeBeanList = new ArrayList<RecordTypeBean>();
        if (total > 0) {
            recordTypeBeanList = recordTypeBeanMapper.selectBeanPage(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(recordTypeBeanList);
    }

    *//**
     * 校验 bean 对象
     *
     * @param
     * @throws Exception 校验异常
     *//*

    private void validateBean(RecordTypeBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getTypeId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }*/
}
