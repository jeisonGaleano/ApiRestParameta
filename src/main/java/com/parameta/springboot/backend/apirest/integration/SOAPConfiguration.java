package com.parameta.springboot.backend.apirest.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class SOAPConfiguration {

    private String clientEndpoint = "http://localhost:8080/parametaSOAP";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.parametasoap.parametasoap.services");
        return marshaller;
    }

    @Bean
    public ClientService soapconnector(Jaxb2Marshaller marshaller) {
        ClientService client = new ClientService();
        client.setDefaultUri(clientEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }






}
