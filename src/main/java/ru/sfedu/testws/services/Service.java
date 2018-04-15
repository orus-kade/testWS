/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.testws.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.sfedu.testws.model.Person;

/**
 *
 * @author sterie
 */
@Path("service")
public class Service {
    //ala database
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
    
    static{
        for(int i = 0; i<10; i++){
            Person person = new Person();
            int id = i+1;
            person.setId(id);
            person.setFullName("Super Name "+i);
            person.setAge(new Random().nextInt(40)+1);
            
            persons.put(id, person);
        }
    }
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getAllPersonsByIdXML")
    @Produces(MediaType.APPLICATION_XML)
    public Response getAllPersonsByIdXML(){
        List<Person> list = new ArrayList<Person>(persons.values());
        GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(list){};
        return Response.status(200).entity(entity).type(MediaType.APPLICATION_XML).build();
    }
    
    @GET
    @Path("/getAllPersonsByIdJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonsByIdJSON(){
        List<Person> list = new ArrayList<Person>(persons.values());
        GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(list){};
        return Response.status(200).entity(entity).type(MediaType.APPLICATION_JSON).build();
    }
}
