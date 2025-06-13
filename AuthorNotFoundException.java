/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

/**
 *
 * @author ACER
 */
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(int id) {
        super("Author ID: " + id + ", not found.");
    }
}
