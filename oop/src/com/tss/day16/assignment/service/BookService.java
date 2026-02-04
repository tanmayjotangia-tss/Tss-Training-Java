package com.tss.day16.assignment.service;

import com.tss.day16.assignment.models.Book;
import com.tss.utils.InputUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookService {

    public static Map<Integer, Book> bookList = new LinkedHashMap<>();

    public static void addBook(int bookNumber) {
        if (bookList.containsKey(bookNumber)) {
            Book book = bookList.get(bookNumber);
            book.incrementCopies();
            return;
        }

        String bookTitle = InputUtil.readString("Enter Book Title: ");
        String bookAuthor = InputUtil.readValidName("Enter Author's name: ");
        String bookCategory = InputUtil.readString("Enter Book Category: ");

        Book book = new Book(bookNumber, bookTitle, bookAuthor, bookCategory);
        bookList.put(bookNumber, book);
    }

    public static void displayAllBooks() {
        if (booksPresent()) {
            System.out.println("------ Library Books ------");
            for (Book book : bookList.values()) {
                System.out.println(book);
            }
        }
    }

    public static boolean booksPresent() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library.");
            return false;
        }
        return true;
    }

    public static void displayBookNumber() {
        System.out.println("------ Book Numbers ------");
        for (Book book : bookList.values()) {
            System.out.println(book.getBookNumber());
        }
    }

    public static void displayBook() {
        int bookNumber = selectBookByNumber();
        if (bookNumber == -1) {
            return;
        }
        if (bookList.containsKey(bookNumber)) {
            Book book = bookList.get(bookNumber);
            System.out.println(book);
        } else {
            System.out.println("No such book found");
        }
    }

    public static int selectBookByNumber() {
        if (booksPresent()) {
            displayBookNumber();
            return InputUtil.readInt("Enter Book Number: ");
        }
        return -1;
    }

    public static Map<Integer, Book> getBookList() {
        return bookList;
    }
}
