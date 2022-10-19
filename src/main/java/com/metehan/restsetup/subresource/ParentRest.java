package com.metehan.restsetup.subresource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("parent")
public class ParentRest {


    @GET
    @Path("plain")
    @Produces("text/plain")
    public String getPlain() {
        return "Düz";
    }


    @GET
    @Path("xml")
    @Produces("application/xml")
    public String getXML() {

        return "<product productId = \"400\" >" +
                "<productName> Cep Telefonu </productName>"+
                "<salesPrice> 15000 </salesPrice>" +
                "</product>";
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public String getJson() {

        return "{" +
                "\"productId\": 400," +
                "\"productName\": \"CepTelefonu\"," +
                "\"salesPrice\": 15000" +
                "}";

    }

}
