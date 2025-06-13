/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Cart {
    private int customerId;
    private List<Book> cartItems = new ArrayList<>();
    
    public Cart() {}
    
    public Cart(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Book> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Book> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void addBook(Book book) {
        cartItems.add(book);
    }
    
    public void removeBook(int bookId) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getId() == bookId) {
                cartItems.remove(i);
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found in cart.");
    }
}
