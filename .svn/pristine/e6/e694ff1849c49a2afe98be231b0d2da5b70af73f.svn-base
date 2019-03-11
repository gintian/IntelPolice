package com.test;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class TestWebService {

    public void sayHello(){
        System.out.println("=================");
    }

    public static void main(String[] args) {
        String address = "http://127.0.0.1:8080/ws";
        Endpoint.publish(address,new TestWebService());
    }
}
