/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstoreapi;

/**
 *
 * @author ACER
 */
public class Author {
    private int id;
    private String name;
    private String biography;
    
    public Author() {}
    
    // Constructor with all fields (except id for POST request cases)
    public Author(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }
    
    public Author(String name, int id, String biography) {
        this.name = name;
        this.id = id;
        this.biography = biography;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    
    
}
