/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 *
 * @author ACER
 */

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    public static Map<Integer, Book> bookList = new HashMap<>();
    private static int currentId = 1;
    
    @POST
    public Response addBook(Book book) {
        if (book.getTitle() == null || book.getIsbn() == null) {
            throw new InvalidInputException("Title and ISBN are required.");
        }
        
        book.setId(currentId++);
        bookList.put(book.getId(), book);

        return Response.status(Response.Status.CREATED).entity(book).build();
    }
    
    @GET
    public Response getBooks() {
        return Response.ok(new ArrayList<>(bookList.values())).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") int id) {
        Book book = bookList.get(id);
        if (book == null) {
            throw new BookNotFoundException(id);
        }
        return Response.ok(book).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, Book updatedBook) {
        Book existingBook = bookList.get(id);
        if (existingBook == null) {
            throw new BookNotFoundException(id);
        }

        updatedBook.setId(id); // Ensure ID remains consistent
        bookList.put(id, updatedBook);
        return Response.ok(updatedBook).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        Book removedBook = bookList.remove(id);
        if (removedBook == null) {
            throw new BookNotFoundException(id);
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
