package com.metehan.restsetup.media;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/json")
public class JsonRest {


    @GET
    @Produces("application/json")
    public String getJson() {

        return "{" +
                "\"productId\": 400," +
                "\"productName\": \"CepTelefonu\"," +
                "\"salesPrice\": 15000" +
                "}";

    }


}
