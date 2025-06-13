/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

/**
 *
 * @author ACER
 */
public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String bookTitle) {
        super("Book title: " + bookTitle + " is out of stock.");
    }
}