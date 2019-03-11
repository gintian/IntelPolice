package com.test;

import com.analysis.DocAnalysis;
import com.analysis.mapper.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDocAnalysis {

    private InvolvedTempMapper involvedTempMapper;
    private DocAnalysis docAnalysis;

    private JsjqdMapper jsjqdMapper;
    private XsXz002Mapper xsXz002Mapper;
    private Xs050Mapper xs050Mapper;
    private Xs052Mapper xs052Mapper;
    private Xs054Mapper xs054Mapper;
    private Xs055Mapper xs055Mapper;
    private Xs059Mapper xs059Mapper;
    private Xz016Mapper xz016Mapper;
    private Xz045Mapper xz045Mapper;
    private ZjbqjdsMapper zjbqjdsMapper;

    private CfqdMapper cfqdMapper;
    private DjbcqdMapper djbcqdMapper;
    private KyjdsMapper kyjdsMapper;
    private KyqdMapper kyqdMapper;
    private Xz0021Mapper xz0021Mapper;

    private Xz0013Mapper xz0013Mapper;
    private Xz0014Mapper xz0014Mapper;

    private Xz0024Mapper xz0024Mapper;




    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new
                String[]{"applicationContext.xml"});
        involvedTempMapper = ac.getBean(InvolvedTempMapper.class);
        docAnalysis = ac.getBean(DocAnalysis.class);

        jsjqdMapper = ac.getBean(JsjqdMapper.class);
        kyjdsMapper = ac.getBean(KyjdsMapper.class);
        xz0013Mapper = ac.getBean(Xz0013Mapper.class);
        xz0014Mapper = ac.getBean(Xz0014Mapper.class);
        xz0024Mapper = ac.getBean(Xz0024Mapper.class);
        xs059Mapper = ac.getBean(Xs059Mapper.class);

        xz016Mapper = ac.getBean(Xz016Mapper.class);
        xsXz002Mapper = ac.getBean(XsXz002Mapper.class);
        xs050Mapper = ac.getBean(Xs050Mapper.class);
        xs052Mapper = ac.getBean(Xs052Mapper.class);
        xs054Mapper = ac.getBean(Xs054Mapper.class);

        xs055Mapper = ac.getBean(Xs055Mapper.class);
        xz045Mapper = ac.getBean(Xz045Mapper.class);
        zjbqjdsMapper = ac.getBean(ZjbqjdsMapper.class);
        cfqdMapper = ac.getBean(CfqdMapper.class);
        djbcqdMapper = ac.getBean(DjbcqdMapper.class);

        kyqdMapper = ac.getBean(KyqdMapper.class);
        xz0021Mapper = ac.getBean(Xz0021Mapper.class);
    }


    @Test
    public void doAnalysis() throws Exception{

        List list = cfqdMapper.selectAll();
        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_CFQD_NEW");
        }
    }



}
