package com.metehan.restsetup.media;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/plain")
public class PlainRest {


    @GET
    @Produces("text/plain")
    public String getPlain() {
        return "Düz";
    }

}
