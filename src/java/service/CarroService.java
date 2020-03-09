/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import Controller.ContatoController;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import static javax.management.Query.times;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.carro;
/**
 *
 * @author SESI_SENAI
 */

@Path("/carro")
public class CarroService {
    
    
    @GET
    //@Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String  getContatos(){   
        return "ok";    
    }
    
    
     @GET
   // @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public carro getCarros(){   
        return null;
    }
       
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
   // @Path("/insert")
    public Response saveJson(carro obj){
        try {
            System.out.println(obj.toString());
            //obj.setId(Controller.getContato().size()+1 );
            //Controller.addContado(obj);
     
            return Response.ok((Object)obj).build();
        }catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
  
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response saveJsonPut(@PathParam("id") int id, carro obj){
        try {
            System.out.println(obj.toString());
           // if(Controller.update(id, obj)){
                return Response.ok((Object)obj).build();
          //  }else{
           //     return Response.ok((Object)"Registro não encontradao.").build();
           // }
            
        }catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
          //  if(Controller.delete(id)){
                return Response.ok().build();
           // }else{
          //      return Response.ok((Object)"Registro não encontradao.").build();
          //  }
         }catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
