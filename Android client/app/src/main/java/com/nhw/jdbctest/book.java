package com.nhw.jdbctest;

public class book {

    private int book_img;
    private String book_title;

    public book(int book_img, String book_title) {
        this.book_img = book_img;
        this.book_title = book_title;
    }

    public int getBook_img() {
        return book_img;
    }

    public String getBook_title() {
        return book_title;
    }


}
