package com.projects;

import java.util.Scanner;

public class Flames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: "); 
        String name1 = sc.nextLine().toLowerCase().replaceAll("\\s", "");

        System.out.print("Enter second name: ");
        String name2 = sc.nextLine().toLowerCase().replaceAll("\\s", "");

        StringBuilder sb1 = new StringBuilder(name1);
        StringBuilder sb2 = new StringBuilder(name2);

        // Step 1: Remove common characters
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                if (sb1.charAt(i) == sb2.charAt(j)) {
                    sb1.deleteCharAt(i);
                    sb2.deleteCharAt(j);
                    i--; // reset index after deletion
                    break;
                }
            }
        }

        // Step 2: Count remaining characters
        int count = sb1.length() + sb2.length();

        // Step 3: FLAMES elimination
        StringBuilder flames = new StringBuilder("FLAMES");
        int index = 0;

        while (flames.length() > 1) {
            index = (index + count - 1) % flames.length();
            flames.deleteCharAt(index);
        }

        // Step 4: Result
        char result = flames.charAt(0);

        System.out.println("\nRelationship Status:");
        switch (result) {
            case 'F':
                System.out.println("Friends");
                break;
            case 'L':
                System.out.println("Love");
                break;
            case 'A':
                System.out.println("Affection");
                break;
            case 'M':
                System.out.println("Marriage");
                break;
            case 'E':
                System.out.println("Enemies");
                break;
            case 'S':
                System.out.println("Siblings");
                break;
        }

        sc.close();
    }
}
