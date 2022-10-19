package com.metehan.restsetup.client;

import com.metehan.restsetup.document.Product;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class BeanClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("json")
                .path("binding");

        Product product = target
                .request("application/json; charset=UTF-8")
                .get(Product.class);

        System.out.println("productId: " + product.getProductId() + "product Name: " + product.getProductName() + "salesPrice: " + product.getSalesPrice());

    }
}
