package com.tss.day16.assignment.service;

import com.tss.day16.assignment.models.Book;
import com.tss.day16.assignment.models.BookCategories;
import com.tss.utils.InputUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookService {

    public static Map<Integer, Book> bookList = new LinkedHashMap<>();

    public static void addBook() {
        int bookNumber = InputUtil.readInt("Enter Book Number: ");
        if (bookList.containsKey(bookNumber)) {
            Book book = bookList.get(bookNumber);
            book.incrementCopies();
            return;
        }

        String bookTitle = InputUtil.readString("Enter Book Title: ");
        String bookAuthor = InputUtil.readValidName("Enter Author's name: ");
//        String bookCategory = InputUtil.readString("Enter Book Category: ");

        System.out.println("Available Book Categories:");
        for(BookCategories category : BookCategories.values()) {
            System.out.println("-" + category.toString());
        }

        BookCategories bookCategory;
        while (true) {
            try{
                String categoryInput = InputUtil.readString("Enter category: ").toUpperCase();
                bookCategory = BookCategories.valueOf(categoryInput);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        Book book = new Book(bookNumber, bookTitle, bookAuthor, bookCategory);
        bookList.put(bookNumber, book);
        System.out.println("Book added successfully!");
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

    public static void removeBook() {
        if (!booksPresent()) {
            return;
        }
        int bookNumber = selectBookByNumber();
        Book removedBook = bookList.remove(bookNumber);

        if (removedBook == null) {
            System.out.println("Invalid book number.");
        } else {
            System.out.println("Book removed successfully!");
        }
    }

    public static void displayBooksTable() {
        if (!booksPresent()) return;

        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-12s %-25s %-20s %-15s %-10s %-10s%n",
                "Book No", "Title", "Author", "Category", "Available", "Total");
        System.out.println("--------------------------------------------------------------------------------");

        for (Book book : bookList.values()) {
            System.out.printf("%-12d %-25s %-20s %-15s %-10d %-10d%n",
                    book.getBookNumber(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getAvailableCopies(),
                    book.getTotalCopies());
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static Map<Integer, Book> getBookList() {
        return bookList;
    }
}
