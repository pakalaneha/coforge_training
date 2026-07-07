package com.coforge.assignment;

import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();

    // Add Book
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Search Book
    void searchBook(String title) {
        boolean found = false;

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Issue Book
    void issueBook(int id) {
        for (Book book : books) {
            if (book.id == id) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return Book
    void returnBook(int id) {
        for (Book book : books) {
            if (book.id == id) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Display All Books
    void displayBooks() {
        for (Book book : books) {
            book.displayBook();
        }
    }
}

