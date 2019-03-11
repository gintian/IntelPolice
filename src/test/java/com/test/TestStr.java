package com.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

public class TestStr {

    @Test
    public void test(){
        String areaId = "substr(caseid,6,2)";

        if (areaId.contains("substr(")){
            areaId = "substr(sa." + areaId.substring(7);
        }else{
            areaId = "sa." + areaId;
        }
        System.out.println(areaId);
    }

    @Test
    public void test1(){
        String qqq = "1111";
        String[] qq= qqq.split(",");
        System.out.println(qq[0]);
    }

    @Test
    public void testxml() throws Exception{


        Document document = new SAXReader().read(this.getClass().getClassLoader().getResourceAsStream("doc.xml"));
        Element doc = (Element) document.selectSingleNode("//docs/doc[@table='DOC_XZ003_NEW']");

        for (Iterator it = doc.elementIterator(); it.hasNext();) {
            Element element = (Element) it.next();
            Attribute involvedColumn = element.attribute("involvedColumn");
            Attribute docColumn = element.attribute("docColumn");
            String involved_column = null;
            String doc_Column =null;

            if (involvedColumn != null){
                involved_column = involvedColumn.getValue();

            }
            if (docColumn != null){
                doc_Column = docColumn.getValue();
            }else {
                doc_Column = element.attribute("value").getValue();
            }
            System.out.print(involved_column+"====");
            System.out.println(doc_Column);

        }
    }
}
