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

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    public static Map<Integer, Cart> cartMap = new HashMap<>();
    
    @GET
    public Response getCart(@PathParam("customerId") int customerId) {
        if (!CustomerResource.customerList.containsKey(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }

        Cart cart = cartMap.getOrDefault(customerId, new Cart(customerId));
        return Response.ok(cart).build();
    }
    
    @POST
    public Response addToCart(@PathParam("customerId") int customerId, Book book) {
        if (!CustomerResource.customerList.containsKey(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }

        Cart cart = cartMap.getOrDefault(customerId, new Cart(customerId));
        cart.addBook(book);
        cartMap.put(customerId, cart);

        return Response.status(Response.Status.CREATED).entity(cart).build();
    }
    
    @DELETE
    @Path("/{bookId}")
    public Response removeFromCart(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId) {
        Cart cart = cartMap.get(customerId);
        if (cart == null) {
            throw new CartNotFoundException(customerId);
        }

        cart.removeBook(bookId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
