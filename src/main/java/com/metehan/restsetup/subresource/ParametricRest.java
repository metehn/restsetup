package com.metehan.restsetup.subresource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("parametric")
public class ParametricRest {

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getJson( @PathParam("id") long productId) {

        return "{" +
                "\"productId\": "+ productId + "," +
                "\"productName\": \"CepTelefonu\"," +
                "\"salesPrice\": 15000" +
                "}";

    }


}
