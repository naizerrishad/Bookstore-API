/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

/**
 *
 * @author ACER
 */
public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(int customerId) {
        super("Cart for customer ID: " + customerId + ", not found.");
    }
}