
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yese
*/ 
@Path("prueba")
public class Prueba {

	@GET
	@Path("{oper}/{s:.*}")
	public Response getRespuesta(
			@PathParam("oper") String oper,
                        @PathParam("s") String todo) {

	   String date =oper+" y "+ todo;

	   return Response.status(200)
		.entity("funciono yupiiii : " + date)
		.build();

	}

}

/*
@Path("/products")
public class Prueba {

    // http://localhost:8081/jaxrs-path-param/api/products/1
    // getProduct with id: 1

    @GET
    @Path("{id}")
    public Response getProduct(@Context UriInfo uriInfo){

        String id = uriInfo.getPathParameters().getFirst("id");

        for (String name : uriInfo.getPathParameters().keySet()){
            System.out.println("ruta name: " + name + " value: " + uriInfo.getPathParameters().getFirst(name));
        }

        return Response
                .ok()
                .entity("getProduct with id: " + id)
                .build();
    }

}
*/
