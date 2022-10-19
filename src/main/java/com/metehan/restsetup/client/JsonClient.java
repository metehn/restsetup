package com.metehan.restsetup.client;



import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import java.io.StringReader;

public class JsonClient {


    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restsetup-1.0-SNAPSHOT/rest")
                .path("json")
                .path("binding");

       String plain = target
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println(plain);

        JsonReader jsonReader = Json.createReader(new StringReader(plain));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();

        long productId = jsonObject.getJsonNumber("productId").longValue();
        String productName = jsonObject.getString("productName");
        double salesPrice = jsonObject.getJsonNumber("salesPrice").doubleValue();

        System.out.println(productId + " " + productName + " " + salesPrice);
    }
}
