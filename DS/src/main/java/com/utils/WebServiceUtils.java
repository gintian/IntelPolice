package com.utils;

import com.utils.ws.WebServiceAnalysis;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class WebServiceUtils {

    public static WebServiceAnalysis webServiceAnalysis;

    public static WebServiceAnalysis getWebServiceAnalysis(){
        if (webServiceAnalysis==null) {
            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
            //factoryBean.setAddress("http://10.164.20.246:8089/IntelPolice/ws/syncAnalysis?wsdl");
            try {
                factoryBean.setAddress(PropertiesUtils.getConfigForPropertiesNameAndKey("SERVICEPATH", "System"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            factoryBean.setServiceClass(WebServiceAnalysis.class);
            webServiceAnalysis = (WebServiceAnalysis) (factoryBean.create());
        }
        return webServiceAnalysis;
    }
}
