package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentInfo {
    int rollno;
    String name;
    double marks;

    StudentInfo(int rollno, String name, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "Roll No: " + rollno + ", Name: " + name + ", Marks: " + marks;
    }
}

public class Student {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<StudentInfo> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by Roll No");
            System.out.println("4. Sort by Roll No");
            System.out.println("5. Sort by Name");
            System.out.println("6. Sort by Marks");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("Marks: ");
                    double m = sc.nextDouble();

                    list.add(new StudentInfo(r, n, m));
                    System.out.println("Added.");
                    break;

                case 2:
                    System.out.println("\n--- Students ---");
                    for (StudentInfo s : list) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter roll no: ");
                    int sr = sc.nextInt();
                    boolean found = false;

                    for (StudentInfo s : list) {
                        if (s.rollno == sr) {
                            System.out.println("Found: " + s);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Not found.");
                    break;

                case 4:
                    for (int i = 0; i < list.size() - 1; i++) {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (list.get(i).rollno > list.get(j).rollno) {
                                StudentInfo temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, temp);
                            }
                        }
                    }
                    System.out.println("Sorted by roll no.");
                    break;

                case 5:
                    for (int i = 0; i < list.size() - 1; i++) {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (list.get(i).name.compareTo(list.get(j).name) > 0) {
                                StudentInfo temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, temp);
                            }
                        }
                    }
                    System.out.println("Sorted by name.");
                    break;

                case 6:
                    for (int i = 0; i < list.size() - 1; i++) {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (list.get(i).marks > list.get(j).marks) {
                                StudentInfo temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, temp);
                            }
                        }
                    }
                    System.out.println("Sorted by marks.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
