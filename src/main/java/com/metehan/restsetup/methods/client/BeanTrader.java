package com.metehan.restsetup.methods.client;

import com.metehan.restsetup.document.Product;
import com.metehan.restsetup.document.Result;
import jakarta.json.Json;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;

public class BeanTrader {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("method")
                .path("trade");

        Product product = new Product(111,"Deneme",223.123);

        Result result = target.request("application/json; charset=UTF-8")
                .post(Entity.entity(product,"application/json"), Result.class);

        System.out.println("BeanTrader: " + result.getResultCode() + " " + result.getResutMessage());
    }
}
