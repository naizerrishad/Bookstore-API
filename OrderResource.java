 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

/**
 *
 * @author ACER
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.*;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    private static Map<Integer, List<Order>> orderHistory = new HashMap<>();
    private static int currentOrderId = 1;
    
    @POST
    public Response placeOrder(@PathParam("customerId") int customerId) {
        if (!CustomerResource.customerList.containsKey(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }

        Cart cart = CartResource.cartMap.get(customerId);
        if (cart == null || cart.getCartItems().isEmpty()) {
            throw new CartNotFoundException(customerId);
        }
        
        for (Book book : cart.getCartItems()) {
            if (book.getStockQuantity() <= 0) {
                throw new OutOfStockException(book.getTitle());
            }
        }

        Order newOrder = new Order(currentOrderId++, customerId, LocalDateTime.now(), new ArrayList<>(cart.getCartItems()));

        List<Order> customerOrders = orderHistory.getOrDefault(customerId, new ArrayList<>());
        customerOrders.add(newOrder);
        orderHistory.put(customerId, customerOrders);

        cart.getCartItems().clear(); // Empty the cart after placing the order

        return Response.status(Response.Status.CREATED).entity(newOrder).build();
    }
    
    @GET
    public Response getCustomerOrders(@PathParam("customerId") int customerId) {
        if (!CustomerResource.customerList.containsKey(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }

        List<Order> customerOrders = orderHistory.getOrDefault(customerId, new ArrayList<>());
        return Response.ok(customerOrders).build();
    }
}


