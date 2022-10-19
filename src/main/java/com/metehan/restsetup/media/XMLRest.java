package com.metehan.restsetup.media;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/xml")
public class XMLRest {


    @GET
    @Produces("application/xml")
    public String getXML() {

        return "<product productId = \"400\" >" +
                "<productName> Cep Telefonu </productName>"+
                "<salesPrice> 15000 </salesPrice>" +
                "</product>";
    }

}
