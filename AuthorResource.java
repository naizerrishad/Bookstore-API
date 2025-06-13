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
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    
    private static Map<Integer, Author> authorList = new HashMap<>();
    private static int currentId = 1;
    
    @POST
    public Response addAuthor(Author author) {
        if (author.getName() == null || author.getBiography() == null) {
            throw new InvalidInputException("Name and biography are required.");
        }
        
        author.setId(currentId++);
        authorList.put(author.getId(), author);
        
        return Response.status(Response.Status.CREATED).entity(author).build();
    }
    
    @GET
    public Response getAllAuthors() {
        return Response.ok(new ArrayList<>(authorList.values())).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getAuthorsById(@PathParam("id") int id) {
        Author author = authorList.get(id);
        if (author == null) {
            throw new AuthorNotFoundException(id);
        }
        return Response.ok(author).build();
    }
    
    @GET
    @Path("/{id}/books")
    public Response getBooksByAuthor(@PathParam("id") int authorId) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : BookResource.bookList.values()) {
            if (book.getAuthorId() == authorId) {
                booksByAuthor.add(book);
            }
        }

        return Response.ok(booksByAuthor).build();
    }
}
