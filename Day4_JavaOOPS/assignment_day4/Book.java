package com.coforge.assignment;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println(id + " - " + title + " by " + author +
                " | Status: " + (isIssued ? "Issued" : "Available"));
    }
}