package com.tss.day16.assignment.models;

public class Book {
    private int bookNumber;
    private String title;
    private String author;
    private String category;
    private int availableCopies;
    private int totalCopies;

    public Book(int bookNumber,String title, String author, String category){
        this.bookNumber=bookNumber;
        this.title=title;
        this.author=author;
        this.category=category;
    }

    public int getBookNumber() {
        return bookNumber;
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
