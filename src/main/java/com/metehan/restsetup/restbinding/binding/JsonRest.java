package com.metehan.restsetup.restbinding.binding;

import com.metehan.restsetup.document.Product;

import jakarta.json.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("json")
public class JsonRest {

    @GET
    @Path("json")
    @Produces("application/json")
    public String getJson() {

        return Json.createObjectBuilder()
                .add("productId", 600L)
                .add("productName", "Cep Telefonu")
                .add("salesPrice", 15000.0)
                .build()
                .toString();
    }

    @GET
    @Path("binding")
    @Produces("application/json; charset=UTF-8")
    public Product getBinding(){

        Product product = new Product(111,"Deneme",223.123);
        return product;
    }
}


