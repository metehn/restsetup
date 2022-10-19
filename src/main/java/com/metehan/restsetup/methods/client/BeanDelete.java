package com.metehan.restsetup.methods.client;

import com.metehan.restsetup.document.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;

public class BeanDelete {

    public static void main(String[] args) {

        long productId = 111L;

        Client client = ClientBuilder.newClient();


        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("method")
                .path("binding")
                .path(String.valueOf(productId));



        target.request("application/json; charset=UTF-8")
                .delete(Void.class);


        System.out.println("BeanDelete: " + productId);

    }
}
