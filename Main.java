import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        boolean running = true;

        // Menu-driven loop
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
            System.out.println("\n=================================");
            System.out.println("    Student Management System    ");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice;
            
            // Exception handling for choice input
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Restart the loop
            }

            switch (choice) {
                case 1 -> handleAddStudent(scanner, manager);
                case 2 -> manager.viewStudents();
                case 3 -> handleSearchStudent(scanner, manager);
                case 4 -> handleUpdateStudent(scanner, manager);
                case 5 -> handleDeleteStudent(scanner, manager);
                case 6 -> {
                    System.out.println("\nExiting the application. Goodbye!");
                    running = false;
                }
                default -> System.out.println("\nInvalid choice. Please select an option between 1 and 6.");
            }
            }
        }
    }

    private static void handleAddStudent(Scanner scanner, StudentManager manager) {
        System.out.println("\n--- Add Student ---");
        try {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            manager.addStudent(id, name, marks);
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. ID must be an integer and Marks must be a number.");
            scanner.nextLine(); // Clear invalid input from buffer
        }
    }

    private static void handleSearchStudent(Scanner scanner, StudentManager manager) {
        System.out.println("\n--- Search Student ---");
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            manager.searchStudent(id);
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. Please enter a valid integer ID.");
            scanner.nextLine(); // Clear invalid input from buffer
        }
    }

    private static void handleUpdateStudent(Scanner scanner, StudentManager manager) {
        System.out.println("\n--- Update Student ---");
        try {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter New Marks: ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            manager.updateStudent(id, newName, newMarks);
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. ID must be an integer and Marks must be a number.");
            scanner.nextLine(); // Clear invalid input from buffer
        }
    }

    private static void handleDeleteStudent(Scanner scanner, StudentManager manager) {
        System.out.println("\n--- Delete Student ---");
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            manager.deleteStudent(id);
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. Please enter a valid integer ID.");
            scanner.nextLine(); // Clear invalid input from buffer
        }
    }
}
