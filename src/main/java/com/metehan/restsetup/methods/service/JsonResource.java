package com.metehan.restsetup.methods.service;

import com.metehan.restsetup.document.Product;
import com.metehan.restsetup.document.Result;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.*;

import java.io.StringReader;

@Path("/method")
public class JsonResource {

    @POST
    @Path("json")
    @Consumes("application/json")
    public void setJson(String json){

        System.out.println("Resource: " + json);

        JsonReader jsonReader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();

        long productId = jsonObject.getJsonNumber("productId").longValue();
        String productName = jsonObject.getString("productName");
        double salesPrice = jsonObject.getJsonNumber("salesPrice").doubleValue();

        System.out.println("setJson: " + productId + " " + productName + " " + salesPrice);

    }

    @POST
    @Path("binding")
    @Consumes("application/json")
    public void setBinding(Product product){

             System.out.println("setBinding: " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());

    }

    @PUT
    @Path("binding")
    @Consumes("application/json")
    public void resetBinding(Product product){

        System.out.println("resetBinding: " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());

    }
    @DELETE
    @Path("binding/{id}")
    public void deleteBinding(@PathParam("id") long productId){
        // Id yeterli olduğu için böyle yaptım  ama Product nesnesi göndererek de silebilirsin.
        System.out.println("deleteBinding: " + productId);

    }

    @POST
    @Path("trade")
    @Consumes("application/json")
    @Produces("application/json")
    public Result tradeBinding(Product product){

        System.out.println("tradeBinding: " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());

        Result result = new Result("111","Message");
        return result;

    }


}
