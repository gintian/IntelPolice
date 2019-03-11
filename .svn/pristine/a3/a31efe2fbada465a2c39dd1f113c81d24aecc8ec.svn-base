package com.test;

import com.analysis.model.BpipUnitBean;
import com.analysis.model.BpipUnitZJBean;
import com.model.bean.DeptBean;
import com.analysis.mapper.BpipUnitBeanMapper;
import com.analysis.mapper.BpipUnitZJBeanMapper;
import com.service.mapper.DeptBeanMapper;
import com.utils.PropertiesUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestAnalysisPB {

    private BpipUnitBeanMapper bpipUnitBeanMapper;
    private BpipUnitZJBeanMapper bpipUnitZJBeanMapper;
    private DeptBeanMapper deptBeanMapper;
    private static List<BpipUnitBean> bpipUnitBeans_All;
    private static List<BpipUnitZJBean> bpipUnitZJBeans_All;

    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new
                String[]{"applicationContext.xml"});
        bpipUnitBeanMapper = ac.getBean(BpipUnitBeanMapper.class);
        bpipUnitZJBeanMapper = ac.getBean(BpipUnitZJBeanMapper.class);
        deptBeanMapper = ac.getBean(DeptBeanMapper.class);
    }

    @Test
    public void test01() throws Exception{
        doAnalysisBpipUnit();
    }

    public void doAnalysisBpipUnit() throws Exception{
        //行政区划分的省级代码,如贵州省:52
        String areaId = PropertiesUtils.get("bpip","xzqh.code");

        //重新定义部门ID
        List<DeptBean> deptBeans = new ArrayList<>();
        DeptBean deptBean = null;

        bpipUnitBeans_All = bpipUnitBeanMapper.selectByPartOfUnitId(areaId,"","","");
        bpipUnitZJBeans_All = bpipUnitZJBeanMapper.selectByPartOfUnitId(areaId,"","","");

        List<BpipUnitBean> bpipUnitBeans = this.getBpipUnitBeans(areaId,"000000");
        BpipUnitBean bpipUnitBean = bpipUnitBeans.get(0);

        deptBean = Bpip2Dept(null,bpipUnitBean);
        deptBeans.add(deptBean);

        analysisUnit(bpipUnitBeans.get(0),deptBeans);


//        for (DeptBean deptBean1 :
//                deptBeans) {
//            deptBeanMapper.insertSelective(deptBean1);
//        }
        for (int i = 0; i < deptBeans.size(); i++) {
            System.out.println(deptBeans.get(i).getId()+"==="+deptBeans.get(i).getName()+"==="+deptBeans.get(i).getParentId()+"==="+deptBeans.get(i).getLeaf());
        }

    }

    public void analysisUnit(BpipUnitBean bpipUnitBean,List<DeptBean> deptBeans) throws Exception{
        String areaId = PropertiesUtils.get("bpip","xzqh.code");

        DeptBean deptBean = null;
        //公安部门代码 贵州省公安厅:520000000000
        String province_UnitId = bpipUnitBean.getUnitid();
        //总队
        List<BpipUnitBean> province_Crops_BpipUnitBeans = this.getBpipUnitBeans(areaId,"0000");
        for (BpipUnitBean province_Crops_BpipUnitBean:province_Crops_BpipUnitBeans) {
            //跳过顶级部门
            if (province_Crops_BpipUnitBean.getUnitid().equals(province_UnitId)) continue;
            //公安部门代码 贵州省公安厅:520000000000
            String province_Crops_UnitId = province_Crops_BpipUnitBean.getUnitid();
            //行政区域代码 贵州省:520000
            String province_Crops_AreaId = province_Crops_UnitId.substring(0,8);
            //支队
            List<BpipUnitBean> province_Detachment_BpipUnitBeans = this.getBpipUnitBeans(province_Crops_AreaId,"00");

            deptBean = Bpip2Dept(bpipUnitBean,province_Crops_BpipUnitBean);
            if (province_Detachment_BpipUnitBeans != null && province_Detachment_BpipUnitBeans.size()>1){
                deptBean.setLeaf("0");
            }else {
                deptBean.setLeaf("1");
            }
            deptBeans.add(deptBean);
            if (province_Detachment_BpipUnitBeans == null) continue;
            //遍历分析支队
            for (BpipUnitBean province_Detachment_BpipUnitBean:province_Detachment_BpipUnitBeans) {
                //跳过顶级部门
                if (province_Detachment_BpipUnitBean.getUnitid().equals(province_Crops_UnitId)) continue;

                //公安部门代码 贵州省公安厅:520000000000
                String province_Detachment_UnitId = province_Detachment_BpipUnitBean.getUnitid();
                //行政区域代码 贵州省:520000
                String province_Detachment_AreaId = province_Detachment_UnitId.substring(0,10);
                //大队
                List<BpipUnitBean> province_Group_BpipUnitBeans = this.getBpipUnitBeans(province_Detachment_AreaId,"");

                deptBean = Bpip2Dept(province_Crops_BpipUnitBean,province_Detachment_BpipUnitBean);
                if (province_Group_BpipUnitBeans != null && province_Group_BpipUnitBeans.size()>1){
                    deptBean.setLeaf("0");
                }else {
                    deptBean.setLeaf("1");
                }
                deptBeans.add(deptBean);

                if (province_Group_BpipUnitBeans == null) continue;
                for (BpipUnitBean province_Group_BpipUnitBean:province_Group_BpipUnitBeans) {
                    //跳过顶级部门
                    if (province_Group_BpipUnitBean.getUnitid().equals(province_Detachment_UnitId)) continue;

                    deptBean = Bpip2Dept(province_Detachment_BpipUnitBean,province_Group_BpipUnitBean);
                    deptBean.setLeaf("1");
                    deptBeans.add(deptBean);

                }
            }
        }
    }

    public List<BpipUnitBean> getBpipUnitBeans(String unitIdBefore,String unitIdAfter){
        List<BpipUnitBean> bpipUnitBeans_Query = new ArrayList<>();

        for (BpipUnitBean bpipUnitBean:bpipUnitBeans_All) {
            String unitId = bpipUnitBean.getUnitid();
            if (this.checkStartAndEnd(unitId,unitIdBefore,unitIdAfter)){
                bpipUnitBeans_Query.add(bpipUnitBean);
            }
        }
        return bpipUnitBeans_Query;
    }

    public boolean checkStartAndEnd(String unitId,String start,String end){
        if (unitId.startsWith(start) && unitId.endsWith(end)){
            return true;
        }else {
            return false;
        }
    }

    private DeptBean Bpip2Dept(BpipUnitBean parent,BpipUnitBean bpipUnitBean){
        DeptBean deptBean = new DeptBean();
        deptBean.setId(bpipUnitBean.getUnitid());

        if (parent == null){
            deptBean.setParentId("520400000000");
            deptBean.setLeaf("0");
        }else {
            deptBean.setParentId(parent.getUnitid());
        }

        deptBean.setName(bpipUnitBean.getUnitname());
        deptBean.setLongName(bpipUnitBean.getLongname());
        deptBean.setStatus("1");
        deptBean.setShortName(bpipUnitBean.getShortname());
        deptBean.setAddress(bpipUnitBean.getAddress());
        deptBean.setPhone(bpipUnitBean.getPhone());

        for (BpipUnitZJBean bpipUnitZJBean:bpipUnitZJBeans_All) {
            if (bpipUnitZJBean.getUnitid().equals(bpipUnitBean.getUnitid())){
                deptBean.setZhId(bpipUnitZJBean.getZhid());
                deptBean.setZjId(bpipUnitZJBean.getZjid());
                bpipUnitZJBeans_All.remove(bpipUnitZJBean);
                break;
            }
        }

        return deptBean;
    }


}

