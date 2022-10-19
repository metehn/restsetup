package com.metehan.restsetup.methods.client;

import com.metehan.restsetup.document.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;

public class BeanPutter {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();


        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("method")
                .path("binding");

        Product product = new Product(111,"Deneme",223.123);

        target.request("application/json; charset=UTF-8")
                .put(Entity.entity(product,"application/json"), Void.class);


        System.out.println("BeanPutter: " +
                product.getProductId() + " " +
                product.getProductName() + " " +
                product.getSalesPrice());
    }
}
