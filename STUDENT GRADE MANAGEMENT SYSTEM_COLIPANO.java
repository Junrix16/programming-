import java.util.Scanner;

public class StudentGradeManagementSystem {

    static Scanner sc = new Scanner(System.in);

    // Set max students the program can hold
    static final int MAX_STUDENTS = 100;

    // Arrays
    static String[] ids = new String[MAX_STUDENTS];
    static String[] names = new String[MAX_STUDENTS];
    static double[][] grades = new double[MAX_STUDENTS][3];
    static double[] averages = new double[MAX_STUDENTS];
    static String[] remarks = new String[MAX_STUDENTS];

    static int studentCount = 0;

    public static void main(String[] args) {
        int choice;
            //show options
        do {
            System.out.println("\nWELCOME TO STUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                    //if choice is exit
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        } while (choice != 3);
    }

    // Add Student
    static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("The student list is full.");
            return;
        }
        //get student id, name, and grades
        System.out.print("Enter Student ID: ");
        ids[studentCount] = sc.nextLine();

        System.out.print("Enter Student Name: ");
        names[studentCount] = sc.nextLine();

        for (int i = 0; i < 3; i++) {
            grades[studentCount][i] =
                    getGradeInput("Enter grade for Subject " + (i + 1) + ": ");
        }  
        computeAverageAndRemark(studentCount);
        studentCount++;

        System.out.println("Student added successfully.");
    }
     //this part computes the average and remarks for the students grade
    static void computeAverageAndRemark(int index) {
        double sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += grades[index][i];
        }

        averages[index] = sum / 3;

        if (averages[index] >= 90) {
            remarks[index] = "Excellent";
        } else if (averages[index] >= 80) {
            remarks[index] = "Very Good";
        } else if (averages[index] >= 70) {
            remarks[index] = "Good";
        } else if (averages[index] >= 60) {
            remarks[index] = "Needs Improvement";
        } else {
            remarks[index] = "Fail";
        }
    }
        //View students
    static void viewStudents() {
        if (studentCount == 0) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-8s %-18s %-10s %-15s%n",
                "ID", "Name", "Average", "Remark");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-8s %-18s %-10.2f %-15s%n",
                    ids[i], names[i], averages[i], remarks[i]);
        }

        System.out.println("-----------------------------------------------------");
    }

    static double getGradeInput(String prompt) {
        double grade;

        while (true) {
            System.out.print(prompt);

            if (sc.hasNextDouble()) {
                grade = sc.nextDouble();

                if (grade >= 0 && grade <= 100) {
                    sc.nextLine(); 
                    return grade;
                } else {
                    System.out.println("Grade must be between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                sc.nextLine();
            }
        }
    }
}