package com.tss.day16.assignment.models;

import java.util.Random;

public class Member {
    private int memberId;
    private String memberName;
    private String memberEmail;

    public Member(String name, String email){
        this.memberId = generateMemberID();
        this.memberName=name;
        this.memberEmail=email;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    private int generateMemberID() {
        Random rand = new Random();
        return rand.nextInt(1_000_000);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }
}
