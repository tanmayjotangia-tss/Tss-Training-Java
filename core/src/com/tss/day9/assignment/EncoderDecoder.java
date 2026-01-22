package com.tss.day9.assignment;

import java.util.Scanner;

public class EncoderDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        while (true) {
            System.out.println("Enter the message to encode");
            message = scanner.nextLine();
            if (validMessage(message)) break;
            System.out.println("Special characters: '@,#,!,*,$' not allowed");
        }

        String encoded = encode(message);
        System.out.println("Encoded message:" + encoded);

        String decoded = decode(encoded);
        System.out.println("Decoded message:" + decoded);

    }

    private static String encode(String message){
        String lower = message.toLowerCase();
        StringBuilder encode = new StringBuilder();

        for(char ch : lower.toCharArray()){
            if(isVowel(ch)){
                encode.append(vowelToSymbol(ch));
            } else if (ch >= 'a' && ch <= 'z') {
                encode.append(shiftForward(ch));
            }else{
                encode.append(ch);
            }
        }
        return encode.reverse().toString();
    }

    private static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) !=-1;
    }

    private static char vowelToSymbol(char ch){
        switch (ch){
            case 'a' :  return '@';
            case 'e' : return '#';
            case 'i' : return '!';
            case 'o' : return '*';
            case 'u' : return '$';
        }
        return ch;
    }

    private static char shiftForward(char ch){
        return (ch=='z')?'a':(char)(ch+1);
    }

    private static String decode(String encode){
        String reverse = new StringBuilder(encode).reverse().toString();
        StringBuilder decode = new StringBuilder();

        for(char ch : reverse.toCharArray()){
            if(isVowelSymbol(ch)){
                decode.append(symbolToVowel(ch));
            } else if (ch >= 'a' && ch <= 'z') {
                decode.append(shiftBackward(ch));
            }else{
                decode.append(ch);
            }
        }
        return decode.toString();
    }

    private static boolean isVowelSymbol(char ch){
        return "@#!*$".indexOf(ch) !=-1;
        }

        private static char symbolToVowel(char ch){
        switch (ch){
            case '@' : return 'a';
            case '#' : return 'e';
            case '!' : return 'i';
            case '*' : return 'o';
            case '$' : return 'u';
        }
        return ch;
    }
    private static char shiftBackward(char ch){
        return (ch=='a')?'z':(char)(ch-1);
    }

    private static boolean validMessage(String message){
        for(char ch : message.toCharArray()){
            if("@#!*$".indexOf(ch)!=-1){
                return false;
            }
        }
        return true;
    }
}
