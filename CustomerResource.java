/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
/**
 *
 * @author ACER
 */

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    public static Map<Integer, Customer> customerList = new HashMap<>();
    private static int currentId = 1;
    
    @POST
    public Response addCustomer(Customer customer) {
        if (customer.getName() == null || customer.getEmail() == null || customer.getPassword() == null) {
            throw new InvalidInputException("Name, email, and password are required.");
        }

        customer.setId(currentId++);
        customerList.put(customer.getId(), customer);

        return Response.status(Response.Status.CREATED).entity(customer).build();
    }
    
    @GET
    public Response getAllCustomers() {
        return Response.ok(new ArrayList<>(customerList.values())).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = customerList.get(id);
        if (!customerList.containsKey(id)) {
            throw new CustomerNotFoundException(id);
        }
        return Response.ok(customer).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        Customer removed = customerList.remove(id);
        if (removed == null) {
            throw new CustomerNotFoundException(id);
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
