package com.product.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.error.DocumentDoesNotExistException;
import com.product.model.Product;
import com.product.service.CouchbaseService;
import com.product.service.ProductServiceConfiguration;

import rx.Observable;

@Path("/product")
public class ProductServiceResource {

	CouchbaseService couchbaseService;
	public ProductServiceResource(ProductServiceConfiguration configuration) {
		couchbaseService = new CouchbaseService(configuration);
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") String id){
		System.out.println("id value : "+ id);
	JsonDocument document = couchbaseService.read(id);
	
	return Response.ok(document.content().toString()).build();
	}
	
	@POST
	@Path("/saveproduct")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public String addProduct(Product product ) {
		JsonObject jsonObject = JsonObject.empty().put("name", product.getName())
		.put("type", product.getType())
		.put("price", product.getPrice());
		
		couchbaseService.createAsync(JsonDocument.create(product.getName(), jsonObject)).toBlocking().single();
		return "post success";
	}
	
	@DELETE
	@Path("/deleteproduct/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam("id") String id) {
		System.out.println("id to delete : "+ id);
		try{
			JsonDocument document =  couchbaseService.delete(id);
			return Response.status(HttpStatus.NO_CONTENT_204).build();
		}catch(DocumentDoesNotExistException e){
			return Response.ok("Document doesn't exist or already deleted").build();
		}catch(Exception e){
			return Response.ok("Delete failed").build();
		}
	}
	
	@GET
	@Path("/async/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getProductAsyc(@PathParam("id") String id){
		Observable<JsonDocument> jsonDoc = couchbaseService.getProductAsync(id);
		return Response.status(HttpStatus.NO_CONTENT_204).build();
	}
	
}
