package com.test;

import com.analysis.model.BpipUnitBean;
import com.model.bean.DeptBean;
import com.analysis.mapper.BpipUnitBeanMapper;
import com.utils.PropertiesUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestAnalysis {

    private BpipUnitBeanMapper bpipUnitBeanMapper;
    private static List<BpipUnitBean> bpipUnitBeans_All;

    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new
                String[]{"applicationContext.xml"});
        bpipUnitBeanMapper = ac.getBean(BpipUnitBeanMapper.class);
    }

    @Test
    public void test01() throws Exception{
        doAnalysisBpipUnit();
    }

    public void doAnalysisBpipUnit(){
        //行政区划分代码位数
        int xzqhNum = Integer.parseInt(PropertiesUtils.get("bpip","xzqh.num"));
        //行政区划分的省级代码,如贵州省:52
        String xzqhCode = PropertiesUtils.get("bpip","xzqh.code");
        //省级部门代码的查询条件 代码尾数:0000000000
        String unitId_Province = PropertiesUtils.get("bpip","unitid.province");
        //市级部门代码的查询条件 代码尾数:00000000
        String unitId_City = PropertiesUtils.get("bpip","unitid.city");
        //区县部门代码的查询条件 代码尾数:000000
        String unitId_County = PropertiesUtils.get("bpip","unitid.county");

        //总队部门代码的查询条件 代码尾数:0000
        String unitId_Crops = PropertiesUtils.get("bpip","unitid.crops");
        //支队部门代码的查询条件 代码尾数:00
        String unitId_Detachment = PropertiesUtils.get("bpip","unitid.detachment");

        //重新定义部门ID
        List<DeptBean> deptBeans = new ArrayList<>();
        DeptBean deptBean = null;

        //省厅
//        List<BpipUnitBean> province_BpipUnitBeans = this.getBpipUnitBeans(xzqhCode,unitId_Province);
        bpipUnitBeans_All = bpipUnitBeanMapper.selectByPartOfUnitId("","","","");
        List<BpipUnitBean> province_BpipUnitBeans = this.getBpipUnitBeans(xzqhCode,unitId_Province);
//        for (BpipUnitBean bpipUnitBean:province_BpipUnitBeans) {
//            this.unit2Dept(bpipUnitBean,deptBeans,"000000000000");
//        }



        String provinceIdStart = "00";
        String cityIdStart = "00";
        String countyIdStart = "00";
        String cropsIdStart = "00";
        String detachmentIdStart = "00";
        String groupIdStart = "00";
        //分析省级直属单位
        for (BpipUnitBean province_BpipUnitBean:province_BpipUnitBeans){

            provinceIdStart = this.increaseId(provinceIdStart);
            deptBean = new DeptBean();
            deptBean.setId(provinceIdStart+cityIdStart+countyIdStart+cropsIdStart+detachmentIdStart+groupIdStart);
            deptBean.setName(province_BpipUnitBean.getLongname());
            deptBeans.add(deptBean);

            analysisUnit(province_BpipUnitBean,deptBeans);
        }

        //模糊查询市级
        List<BpipUnitBean> city_BpipUnitBeans = this.getBpipUnitBeans(xzqhCode,unitId_City);

        //分析市级直属单位
        for (BpipUnitBean city_BpipUnitBean:city_BpipUnitBeans){
//            //公安部门代码 贵州省公安厅:520000000000
//            String city_unitId = city_BpipUnitBean.getUnitid();
//            //行政区域代码 贵州省:520000
//            String city_areaId = city_unitId.substring(0,xzqhNum);
//            //直属总队
//            List<BpipUnitBean> province_Unit_BpipUnitBeans = this.getBpipUnitBeans(city_areaId,unitId_Crops);
            if (city_BpipUnitBean.getUnitid().equals("520000000000")) continue;

            cityIdStart = this.increaseId(cityIdStart);
            deptBean.setId(provinceIdStart+cityIdStart+countyIdStart+cropsIdStart+detachmentIdStart+groupIdStart);
            deptBean.setName(city_BpipUnitBean.getLongname());
            deptBeans.add(deptBean);

            analysisUnit(city_BpipUnitBean,deptBeans);

            List<BpipUnitBean> county_BpipUnitBeans = this.getBpipUnitBeans(city_BpipUnitBean.getUnitid().substring(0,4),unitId_County);

            for (BpipUnitBean county_BpipUnitBean:county_BpipUnitBeans) {
                if (county_BpipUnitBean.getUnitid().equals(city_BpipUnitBean.getUnitid())) continue;
                countyIdStart = this.increaseId(countyIdStart);
                deptBean.setId(provinceIdStart+cityIdStart+countyIdStart+cropsIdStart+detachmentIdStart+groupIdStart);
                deptBean.setName(county_BpipUnitBean.getLongname());
                deptBeans.add(deptBean);

                analysisUnit(county_BpipUnitBean,deptBeans);
            }

        }

        for (int i = 0; i < deptBeans.size(); i++) {
            System.out.println(deptBeans.get(i).getId()+"==="+deptBeans.get(i).getName()+"==="+deptBeans.get(i).getParentId());
        }

    }

    public void analysisUnit(BpipUnitBean bpipUnitBean,List<DeptBean> deptBeans){
        String provinceIdStart = "00";
        String cityIdStart = "00";
        String countyIdStart = "00";
        String cropsIdStart = "00";
        String detachmentIdStart = "00";
        String groupIdStart = "00";

        DeptBean deptBean = null;
        //公安部门代码 贵州省公安厅:520000000000
        String province_UnitId = bpipUnitBean.getUnitid();
        //行政区域代码 贵州省:520000
        String province_AreaId = province_UnitId.substring(0,6);
        //总队
        List<BpipUnitBean> province_Crops_BpipUnitBeans = this.getBpipUnitBeans(province_AreaId,"0000");
        cropsIdStart = "00";
        for (BpipUnitBean province_Crops_BpipUnitBean:province_Crops_BpipUnitBeans) {
            //跳过顶级部门
            if (province_Crops_BpipUnitBean.getUnitid().equals(province_UnitId)) continue;

            cropsIdStart= this.increaseId(cropsIdStart);
            deptBean = new DeptBean();
            deptBean.setId(provinceIdStart+cityIdStart+countyIdStart+cropsIdStart+detachmentIdStart+groupIdStart);
            deptBean.setName(province_Crops_BpipUnitBean.getLongname());
            deptBean.setParentId(province_UnitId);
            deptBeans.add(deptBean);

            //公安部门代码 贵州省公安厅:520000000000
            String province_Crops_UnitId = province_Crops_BpipUnitBean.getUnitid();
            //行政区域代码 贵州省:520000
            String province_Crops_AreaId = province_Crops_UnitId.substring(0,8);
            //支队
            List<BpipUnitBean> province_Detachment_BpipUnitBeans = this.getBpipUnitBeans(province_Crops_AreaId,"00");
            detachmentIdStart = "00";
            //遍历分析支队
            for (BpipUnitBean province_Detachment_BpipUnitBean:province_Detachment_BpipUnitBeans) {
                //跳过顶级部门
                if (province_Detachment_BpipUnitBean.getUnitid().equals(province_Crops_UnitId)) continue;

                detachmentIdStart = this.increaseId(detachmentIdStart);
                deptBean = new DeptBean();
                deptBean.setId(provinceIdStart+cityIdStart+countyIdStart+cropsIdStart+detachmentIdStart+groupIdStart);
                deptBean.setName(province_Detachment_BpipUnitBean.getLongname());
                deptBean.setParentId(province_Detachment_BpipUnitBean.getUnitid());
                deptBeans.add(deptBean);

                //公安部门代码 贵州省公安厅:520000000000
                String province_Detachment_UnitId = province_Detachment_BpipUnitBean.getUnitid();
                //行政区域代码 贵州省:520000
                String province_Detachment_AreaId = province_Detachment_UnitId.substring(0,10);
                //大队
                List<BpipUnitBean> province_Group_BpipUnitBeans = this.getBpipUnitBeans(province_Detachment_AreaId,"");
                groupIdStart = "00";
                for (BpipUnitBean province_Group_BpipUnitBean:province_Group_BpipUnitBeans) {
                    //跳过顶级部门
                    if (province_Group_BpipUnitBean.getUnitid().equals(province_Detachment_UnitId)) continue;
                    groupIdStart = this.increaseId(groupIdStart);

                    deptBean = new DeptBean();
                    deptBean.setId(provinceIdStart+cityIdStart+countyIdStart+cropsIdStart+detachmentIdStart+groupIdStart);
                    deptBean.setName(province_Group_BpipUnitBean.getLongname());
                    deptBean.setParentId(province_Group_BpipUnitBean.getUnitid());
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

    public String increaseId(String deptIdList){
        return String.format("%02d", Integer.parseInt(deptIdList)+1);
    }

    public void unit2Dept(BpipUnitBean bpipUnitBean,List<DeptBean> deptBeans,String parentId){

        int grade = this.getGradeByUnitId(bpipUnitBean.getUnitid());

        DeptBean deptBean = new DeptBean();
        deptBean.setId(bpipUnitBean.getUnitid());
        deptBean.setName(bpipUnitBean.getLongname());
        deptBean.setParentId(parentId);
        deptBeans.add(deptBean);


        int xzqhNum = Integer.parseInt(PropertiesUtils.get("bpip","xzqh.num"));
        int deptIdGrades = Integer.parseInt(PropertiesUtils.get("bpip","deptid.grades"));
        //公安部门代码 贵州省公安厅:520000000000
        String unitId = bpipUnitBean.getUnitid();
        //行政区域代码 贵州省:520000
        String unitIdBefore = "";
        String unitIdAfter = "";

        unitIdBefore = unitId.substring(0,grade*2);
        if (grade <= 4) unitIdAfter = "00000000".substring((grade-1)*2);

        List<BpipUnitBean> bpipUnitBeans = this.getBpipUnitBeans(unitIdBefore,unitIdAfter);
        if (grade<=2) bpipUnitBeans.addAll(this.getBpipUnitBeans(unitId.substring(0,6),"0000"));

        for (BpipUnitBean bpipUnitBean1:bpipUnitBeans) {
            //跳过顶级部门
            if (bpipUnitBean1.getUnitid().equals(bpipUnitBean.getUnitid())) continue;
            this.unit2Dept(bpipUnitBean1,deptBeans,bpipUnitBean.getUnitid());
        }
    }

    public int getGradeByUnitId(String unitId){
        if (unitId.substring(2).equals(PropertiesUtils.get("bpip","unitid.province"))){//0000000000
            return 1;
        }else if (unitId.substring(4).equals(PropertiesUtils.get("bpip","unitid.city"))){//00000000
            return 2;
        }else if (unitId.substring(6).equals(PropertiesUtils.get("bpip","unitid.county"))){//000000
            return 3;
        }else if (unitId.substring(8).equals(PropertiesUtils.get("bpip","unitid.crops"))){//0000
            return 4;
        }else if (unitId.substring(10).equals(PropertiesUtils.get("bpip","unitid.detachment"))){//00
            return 5;
        }else{
            return 6;
        }
    }

}

