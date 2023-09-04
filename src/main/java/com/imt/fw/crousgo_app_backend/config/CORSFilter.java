package com.imt.fw.crousgo_app_backend.config;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
    
            throws IOException {
         System.out.println("CORSFilter called");       
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*"); 
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "POST, PUT, DELETE, OPTIONS, HEAD");
    }
}