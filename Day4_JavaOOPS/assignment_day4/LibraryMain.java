package com.coforge.assignment;

public class LibraryMain {
    public static void main(String[] args) {

        Library library = new Library();

        Member member = new Member(1, "Alice");

        library.addBook(new Book(101, "Java Programming", "James Gosling"));
        library.addBook(new Book(102, "Python Basics", "Guido van Rossum"));
        library.addBook(new Book(103, "Data Structures", "Mark Allen"));

        System.out.println("\nAll Books:");
        library.displayBooks();

        System.out.println("\nSearching for Java Programming:");
        library.searchBook("Java Programming");

        System.out.println("\nIssuing Book ID 101:");
        library.issueBook(101);

        System.out.println("\nReturning Book ID 101:");
        library.returnBook(101);

        System.out.println("\nBooks After Transactions:");
        library.displayBooks();
    }
}