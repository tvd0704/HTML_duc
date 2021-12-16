package net.codejava.ws;


import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Path("/products")
public class ProductResource {

	private ProductDAO dao=ProductDAO.getInstance();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Product> list(){
		
		return dao.listAll();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Product product) throws URISyntaxException {
		
	int newProductId=	dao.add(product);
	
	URI uri=new URI("/products"+ newProductId);
	return Response.created(uri).build();
	
	}

}
