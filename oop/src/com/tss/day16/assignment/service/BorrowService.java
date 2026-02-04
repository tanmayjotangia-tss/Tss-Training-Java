package com.tss.day16.assignment.service;

import com.tss.day16.assignment.models.Book;
import com.tss.day16.assignment.models.Member;
import com.tss.utils.InputUtil;

import java.util.*;

public class BorrowService {

    private static Map<Integer, Book> bookList = BookService.getBookList();
    private static Map<Integer, Member> memberList = MemberService.getMemberList();
    private static Map<Integer, Set<Integer>> borrowedBookByMember = new HashMap<>();

    public static void borrowBook() {
        int bookNumber = BookService.selectBookByNumber();
        int memberId = MemberService.selectMemberById();

        Book book = bookList.get(bookNumber);
        if (book == null) {
            throw new IllegalArgumentException("Select a valid Book Number");
        }
        if (!memberList.containsKey(memberId)) {
            throw new IllegalArgumentException("Select a valid Member ID");
        }

        borrowedBookByMember.putIfAbsent(memberId, new HashSet<>());

        if (borrowedBookByMember.get(memberId).contains(bookNumber)) {
            throw new IllegalArgumentException("Member already borrowed this book");
        }

        if (!book.isAvailabe()) {
            throw new IllegalArgumentException("No copies of this book are available");
        }

        book.borrowCopy();
        borrowedBookByMember.get(memberId).add(bookNumber);

        System.out.println("Book borrowed successfully!");
    }

    public static void returnBook() {
        int memberId = MemberService.selectMemberById();
        Set<Integer> borrowed = getBorrowedBooksByMember(memberId);

        if (borrowed.isEmpty()) {
            throw new IllegalArgumentException("No books borrowed by this member");
        }

        displayBorrowedBooksNumberByMember();

        int bookNumber = InputUtil.readInt("Enter the book number you want to return: ");

        if (!borrowed.contains(bookNumber)) {
            throw new IllegalArgumentException("This book was not borrowed by the member");
        }

        Book book = bookList.get(bookNumber);
        book.returnCopy();
        borrowed.remove(bookNumber);

        System.out.println("Book returned successfully!");
    }

    public static Set<Integer> getBorrowedBooksByMember(int memberId) {
        return borrowedBookByMember.getOrDefault(memberId, new HashSet<>());
    }

    public static void displayBorrowedBooksByMember() {
        int memberId = MemberService.selectMemberById();
        Set<Integer> borrowed = getBorrowedBooksByMember(memberId);

        if (borrowed.isEmpty()) {
            System.out.println("No books borrowed by member ID " + memberId);
            return;
        }

        System.out.println("Books borrowed by member ID " + memberId + ":");
        for (int bookNumber : borrowed) {
            Book book = bookList.get(bookNumber);
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    public static void displayBorrowedBooksNumberByMember() {
        int memberId = MemberService.selectMemberById();
        Set<Integer> borrowed = getBorrowedBooksByMember(memberId);

        if (borrowed.isEmpty()) {
            System.out.println("No books borrowed by member ID " + memberId);
            return;
        }
        System.out.println("Book numbers borrowed by member ID " + memberId + ":");
        for (int bookNumber : borrowed) {
            System.out.println(bookNumber);
        }
    }

    public static void whoBorrowedBook() {
        BookService.displayBookNumber();
        int bookNumber = InputUtil.readInt("Enter book number: ");

        for (Map.Entry<Integer, Set<Integer>> entry : borrowedBookByMember.entrySet()) {
            int memberId = entry.getKey();
            Set<Integer> borrowedBooks = entry.getValue();

            if (borrowedBooks.contains(bookNumber)) {
                System.out.println(memberList.get(memberId));
            }
        }
        System.out.println("This book has not been borrowed by anyone.");
    }

}
