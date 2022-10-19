package com.metehan.restsetup.restbinding.binding;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import com.metehan.restsetup.document.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;


@Path("xml")
public class XMLRest {

    @GET
    @Path("binding")
    @Produces("application/xml; charset=UTF-8")
    public Product getBinding(){

        Product product = new Product(111,"Deneme",123.123);
        return product;
    }

    @GET
    @Path("processing")
    @Produces("application/xml")
    public String getProcessing(){
        try {
            Document document = createDocument();
            Element product = document.createElement("product");
            document.appendChild(product);
            product.setAttribute("productId",Long.toString(401L));

            Element productName = document.createElement("productName");
            productName.setTextContent("Cep Telefonu");
            product.appendChild(productName);

            Element salesPrice = document.createElement("salesPrice");
            salesPrice.setTextContent(Double.toString(15000.0));
            product.appendChild(salesPrice);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));


            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }


    }

    public Document createDocument() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory builderFactory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.newDocument();


        return document;
    }

}
