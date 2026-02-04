package com.tss.day16.assignment.controller;

import com.tss.day16.assignment.service.BookService;
import com.tss.day16.assignment.service.BorrowService;
import com.tss.day16.assignment.service.MemberService;
import com.tss.utils.InputUtil;

public class LibraryController {
    public static void start(){
        while (true){
            displayMenu();
            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice){
                case 1 -> bookService();
                case 2 -> memberService();
                case 3 -> borrowBookService();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void displayMenu(){
        System.out.println("----------------Library Book Borrow System------------------");
        System.out.println("1. Book Service");
        System.out.println("2. Member Service");
        System.out.println("3. Borrow Service");
        System.out.println("4. Exit");
    }

    private static void bookServiceMenu(){
        System.out.println("------------Book Service Menu---------------");
        System.out.println("1. Add Book");
        System.out.println("2. Display all books");
        System.out.println("3. Display single book");
        System.out.println("4. Remove book");
        System.out.println("5. Return to main menu");
    }

    private static void memberServiceMenu(){
        System.out.println("-------------Member Service Menu---------------");
        System.out.println("1. Add Member");
        System.out.println("2. Display all members");
        System.out.println("3. Display single member");
        System.out.println("4. Remove member");
        System.out.println("4. Return to main menu");
    }

    private static void borrowBookServiceMenu(){
        System.out.println("-------------Borrow Book Service Menu---------------");
        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. List of Book borrowed by member");
        System.out.println("4. Display member who borrowed the book");
        System.out.println("5. Return to main menu");
    }

    private static void bookService(){
        while (true){
            bookServiceMenu();
            int choice = InputUtil.readInt("Enter your choice: ");
            try{
                switch (choice){
                    case 1 -> BookService.addBook();
                    case 2 -> BookService.displayBooksTable();
                    case 3 -> BookService.displayBook();
                    case 4 -> BookService.removeBook();
                    case 5 -> {
                        System.out.println("Return to main menu...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void memberService(){
        while (true){
            memberServiceMenu();
            int choice = InputUtil.readInt("Enter your choice: ");
            try{
                switch (choice){
                    case 1 -> MemberService.addMember();
                    case 2 -> MemberService.displayMembersTable();
                    case 3 -> MemberService.displayMember();
                    case 4 -> MemberService.removeMember();
                    case 5 -> {
                        System.out.println("Return to main menu...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void borrowBookService(){
        while (true){
            borrowBookServiceMenu();
            int choice = InputUtil.readInt("Enter your choice: ");
            try{
                switch (choice){
                    case 1 -> BorrowService.borrowBook();
                    case 2 -> BorrowService.returnBook();
                    case 3 -> BorrowService.displayBorrowedBooksTableByMember();
                    case 4 -> BorrowService.whoBorrowedBook();
                    case 5 -> {
                        System.out.println("Return to main menu...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
