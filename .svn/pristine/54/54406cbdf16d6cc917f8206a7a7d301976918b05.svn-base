package com.analysis;

import com.analysis.model.BpipUnitBean;
import com.analysis.model.BpipUnitZJBean;
import com.model.bean.DeptBean;
import com.analysis.mapper.BpipUnitBeanMapper;
import com.analysis.mapper.BpipUnitZJBeanMapper;
import com.service.mapper.DeptBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 解析部门数据
 */
@Service
public class BpipUnitAnalysis {

    @Autowired
    private BpipUnitBeanMapper bpipUnitBeanMapper;
    @Autowired
    private BpipUnitZJBeanMapper bpipUnitZJBeanMapper;
    @Autowired
    private DeptBeanMapper deptBeanMapper;

    private static List<BpipUnitBean> bpipUnitBeans_All;
    private static List<BpipUnitZJBean> bpipUnitZJBeans_All;
    private static String areaId;

    /**
     * 解析部门数据
     * @param areaId            行政区划分的代码
     * @param startDate         hck_gxsj 开始时间
     * @param endDate           hck_gxsj 截止时间
     * @throws Exception
     */
    @Transactional
    public void doAnalysis(String areaId,String startDate,String endDate) throws Exception{
        //行政区划分的代码,如平坝:520421
        this.areaId=areaId;

        //重新定义部门ID
        List<DeptBean> deptBeans = new ArrayList<>();
        DeptBean deptBean = null;

        //获取所有部门数据
        bpipUnitBeans_All = bpipUnitBeanMapper.selectByPartOfUnitId(areaId,"",startDate,endDate);
        bpipUnitZJBeans_All = bpipUnitZJBeanMapper.selectByPartOfUnitId(areaId,"",startDate,endDate);

        //获取顶级部门,平坝县公安局
        List<BpipUnitBean> bpipUnitBeans = this.getBpipUnitBeans(areaId,"000000");
        BpipUnitBean bpipUnitBean = bpipUnitBeans.get(0);

        //顶级部门解析,平坝县公安局,返回所有已解析的下级部门
        deptBean = Bpip2Dept(null,bpipUnitBean);
        deptBeans.add(deptBean);
        analysisUnit(bpipUnitBeans.get(0),deptBeans);

        //解析其余部门
        DeptBean deptBean2 = null;
        for (DeptBean deptBean1 :deptBeans) {
            deptBean2 = deptBeanMapper.selectDeptEqId(deptBean1.getId());
            if (deptBean2==null){
                deptBeanMapper.insertSelective(deptBean1);
            }else {
                deptBeanMapper.updateByPrimaryKeySelective(deptBean1);
            }

        }

    }

    /**
     * 更据顶级部门解析下面的部门
     * 行政代码分为6个等级
     * 520421000000
     * 贵州省 安顺市 平坝县 公安局
     *
     * 52    04   21  00    00       00
     * 省    市   县   总队  支队      大队
     *
     * Crops        总队
     * Detachment   支队
     * Group        大队
     *
     * @param bpipUnitBean
     * @param deptBeans
     * @throws Exception
     */
    private void analysisUnit(BpipUnitBean bpipUnitBean,List<DeptBean> deptBeans) throws Exception{

        DeptBean deptBean = null;
        //公安部门代码 平坝县公安局:520421000000
        String province_UnitId = bpipUnitBean.getUnitid();
        //获取所有总队级的部门
        List<BpipUnitBean> province_Crops_BpipUnitBeans = this.getBpipUnitBeans(areaId,"0000");
        //遍历所有总队级的部门
        for (BpipUnitBean province_Crops_BpipUnitBean:province_Crops_BpipUnitBeans) {
            //跳过顶级部门
            if (province_Crops_BpipUnitBean.getUnitid().equals(province_UnitId)) continue;

            //总队部门代码
            String province_Crops_UnitId = province_Crops_BpipUnitBean.getUnitid();
            String province_Crops_AreaId = province_Crops_UnitId.substring(0,8);

            //获取所有支队级的部门
            List<BpipUnitBean> province_Detachment_BpipUnitBeans = this.getBpipUnitBeans(province_Crops_AreaId,"00");
            deptBean = Bpip2Dept(bpipUnitBean,province_Crops_BpipUnitBean);

            //判断是否有下级部门,deptBean的leaf属性这个部门是否为父节点
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

                //支队部门代码
                String province_Detachment_UnitId = province_Detachment_BpipUnitBean.getUnitid();
                String province_Detachment_AreaId = province_Detachment_UnitId.substring(0,10);

                //获取所有大队部门
                List<BpipUnitBean> province_Group_BpipUnitBeans = this.getBpipUnitBeans(province_Detachment_AreaId,"");

                //判断是否有下级部门,deptBean的leaf属性这个部门是否为父节点
                deptBean = Bpip2Dept(province_Crops_BpipUnitBean,province_Detachment_BpipUnitBean);
                if (province_Group_BpipUnitBeans != null && province_Group_BpipUnitBeans.size()>1){
                    deptBean.setLeaf("0");
                }else {
                    deptBean.setLeaf("1");
                }
                deptBeans.add(deptBean);

                if (province_Group_BpipUnitBeans == null) continue;
                //遍历分析大队级
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

    /**
     * 根据unitId模糊查询部门效果与一下sql效果一致
     * select * from table where id like 'xxx%' and id like '%xxx';
     *
     * @param unitIdBefore
     * @param unitIdAfter
     * @return
     */
    private List<BpipUnitBean> getBpipUnitBeans(String unitIdBefore,String unitIdAfter){
        List<BpipUnitBean> bpipUnitBeans_Query = new ArrayList<>();

        for (BpipUnitBean bpipUnitBean:bpipUnitBeans_All) {
            String unitId = bpipUnitBean.getUnitid();
            if (this.checkStartAndEnd(unitId,unitIdBefore,unitIdAfter)){
                bpipUnitBeans_Query.add(bpipUnitBean);
            }
        }
        return bpipUnitBeans_Query;
    }


    private boolean checkStartAndEnd(String unitId,String start,String end){
        if (unitId.startsWith(start) && unitId.endsWith(end)){
            return true;
        }else {
            return false;
        }
    }


    /**
     * BpipUnit 转换为 Dept
     * @param parent
     * @param bpipUnitBean
     * @return
     */
    private DeptBean Bpip2Dept(BpipUnitBean parent,BpipUnitBean bpipUnitBean){
        DeptBean deptBean = new DeptBean();
        deptBean.setId(bpipUnitBean.getUnitid());

        if (parent == null){
            deptBean.setParentId(areaId + "000000");
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
