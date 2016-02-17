package com.pricing;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.document.JsonDocument;

@RestController
public class PricingController {

	private final CouchbaseService couchbaseService;

    @Autowired
    public PricingController(CouchbaseService couchbaseService) {
        this.couchbaseService = couchbaseService;
    }
	
    @GET
	@RequestMapping("/{id}")
	public Response getPrice(@PathVariable("id") String id){
		System.out.println("id recieved:  " + id);
		JsonDocument document = couchbaseService.read(id);
		return Response.ok(document.content().toString()).build();
	}
}
