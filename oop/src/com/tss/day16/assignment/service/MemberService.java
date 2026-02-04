package com.tss.day16.assignment.service;

import com.tss.day16.assignment.models.Member;
import com.tss.utils.InputUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MemberService {

    private static Map<Integer, Member> memberList = new HashMap<>();
    private static Set<String> emailList = new HashSet<>();

    public static void addMember(){
        String name = InputUtil.readValidName("Enter member's name: ");
        String email = InputUtil.readEmail("Enter member's email: ");

        if(emailList.contains(email)){
            throw new IllegalArgumentException("Email already registered");
        }
        Member member = new Member(name,email);
        memberList.put(member.getMemberId(), member);
        emailList.add(email);
        System.out.println("Member added successfully!");
    }

    public static void displayAllMembers(){
        if(memberPresent()){
            System.out.println("-----List of Members-------");
            for(Member member : memberList.values()){
                System.out.println(member);
            }
        }
    }

    public static void displayMemberNumber(){
            System.out.println("-------Member Numbers--------");
            for(Member member : memberList.values()){
                System.out.println("- " + member.getMemberId());
            }
    }

    public static int selectMemberById(){
        if(memberPresent()){
            displayMemberNumber();
            return InputUtil.readInt("Enter member number: ");
        }
        return -1;
    }

    public static boolean memberPresent(){
        if(memberList.isEmpty()){
            System.out.println("No member found");
            return false;
        }
        return true;
    }

    public static void displayMember(){
        if(memberPresent()){
            int memberId = selectMemberById();
            Member member = memberList.get(memberId);
            System.out.println(member);
        }
    }

    public static void removeMember() {
        if (!memberPresent()) {
            return;
        }
        int memberId = selectMemberById();
        Member removedMember = memberList.remove(memberId);

        if (removedMember == null) {
            System.out.println("Invalid member ID. No member removed.");
            return;
        }
        emailList.remove(removedMember.getMemberEmail());
        System.out.println("Member removed successfully!");
    }

    public static void displayMembersTable() {
        if (!memberPresent()) return;

        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-12s %-20s %-25s%n",
                "Member ID", "Name", "Email");
        System.out.println("-----------------------------------------------------------");

        for (Member member : memberList.values()) {
            System.out.printf("%-12d %-20s %-25s%n",
                    member.getMemberId(),
                    member.getMemberName(),
                    member.getMemberEmail());
        }

        System.out.println("-----------------------------------------------------------");
    }



    public static Map<Integer,Member> getMemberList(){
        return memberList;
    }
}
