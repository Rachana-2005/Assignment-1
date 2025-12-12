

package com.assignment;

import java.util.Scanner;

// Custom Exception
class ExceptionLineTooLong extends Exception {
    ExceptionLineTooLong() {
        super("The string is too long");
    }
}

public class handling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String str = sc.nextLine();

            if (str.length() > 80) {
                throw new ExceptionLineTooLong();
            }

            System.out.println("Length of string: " + str.length());

        } catch (ExceptionLineTooLong e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
