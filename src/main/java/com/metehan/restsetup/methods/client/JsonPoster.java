package com.metehan.restsetup.methods.client;

import com.metehan.restsetup.document.Product;
import jakarta.json.Json;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;

public class JsonPoster {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();


        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("method")
                .path("plain");

        String json = Json.createObjectBuilder()
                .add("productId", 600L)
                .add("productName", "Cep Telefonu")
                .add("salesPrice", 15000.0)
                .build()
                .toString();;

        target.request("application/json; charset=UTF-8")
                .post(Entity.entity(json,"application/json"), Void.class);

        System.out.println("JsonPoster: " + json);


    }

}
