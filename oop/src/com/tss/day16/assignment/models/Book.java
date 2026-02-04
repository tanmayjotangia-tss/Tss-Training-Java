package com.tss.day16.assignment.models;

import com.tss.day16.assignment.service.BookService;

import static com.tss.day16.assignment.service.BookService.bookList;

public class Book {
    private int bookNumber;
    private String title;
    private String author;
//    private String category;
    private int availableCopies;
    private int totalCopies;
    private BookCategories category;

    public Book(int bookNumber,String title, String author, BookCategories category){
        this.bookNumber=bookNumber;
        this.title=title;
        this.author=author;
        this.category=category;
        this.availableCopies=1;
        this.totalCopies=1;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookCategories getCategory() {
        return category;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }


    public boolean isAvailabe(){
        return availableCopies > 0;
    }

    public void incrementCopies(){
        availableCopies++;
        totalCopies++;
        System.out.println("Book copy incremented !!");
    }

    public void borrowCopy(){
        if(availableCopies <=0){
            throw new IllegalArgumentException("No available copy to borrow");
        }
        availableCopies--;
    }

    public void returnCopy(){
        if(availableCopies < totalCopies){
            availableCopies++;
        }
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", availableCopies=" + availableCopies +
                ", totalCopies=" + totalCopies +
                '}';
    }
}
