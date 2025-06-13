/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Order {
    private int orderId;
    private int customerId;
    private LocalDateTime orderDate;
    private List<Book> books;
    
    public Order() {};
    
    public Order( int customerId, LocalDateTime orderDate, List<Book> books) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.books = books;
    }

    public Order(int orderId, int customerId, LocalDateTime orderDate, List<Book> books) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.books = books;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
