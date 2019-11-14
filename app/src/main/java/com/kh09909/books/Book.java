package com.kh09909.books;

public class Book {

    private String title;
    private String auther;
    private String isbn;
    private String category_name;

    public Book() {
    }

    public Book(String title, String auther, String isbn, String category_name) {
        this.title = title;
        this.auther = auther;
        this.isbn = isbn;
        this.category_name = category_name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuther() {
        return auther;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategory_name() {
        return category_name;
    }
}
