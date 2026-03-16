package com.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   Welcome to the Demo App!");
        System.out.println("=================================");
        System.out.println();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println();
        System.out.println("Hello, " + name + "! Nice to meet you.");
        System.out.println("This is a simple Java command-line application.");
        System.out.println();
        System.out.println("=================================");
        System.out.println("   Thanks for using Demo App!");
        System.out.println("=================================");

        scanner.close();
    }
}
