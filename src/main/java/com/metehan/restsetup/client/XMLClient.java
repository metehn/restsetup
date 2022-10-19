package com.metehan.restsetup.client;

import com.metehan.restsetup.document.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class XMLClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("xml")
                .path("binding");

        String plain = target
                .request("application/xml; charset=UTF-8")
                .get(String.class);

        System.out.println(plain);


        Product product = target
                .request("application/xml; charset=UTF-8")
                .get(Product.class);

        System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());



        try {
            DocumentBuilderFactory builderFactory =  DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
