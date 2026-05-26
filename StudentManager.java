import java.util.ArrayList;

public class StudentManager {
    // Collections framework used to store students
    private final ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Add Student operation
    public void addStudent(int id, String name, double marks) {
        // Prevent duplicate IDs (optional but good practice)
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("A student with ID " + id + " already exists.");
                return;
            }
        }
        
        Student newStudent = new Student(id, name, marks);
        students.add(newStudent);
        System.out.println("\nStudent added successfully.");
    }

    // View All Students operation
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found. The list is empty.");
            return;
        }
        
        System.out.println("\n--- All Students ---");
        for (Student student : students) {
            System.out.println(student);
            System.out.println("--------------------");
        }
    }

    // Search Student by ID
    public void searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("\n" + student);
                return;
            }
        }
        System.out.println("\nStudent with ID " + id + " not found.");
    }

    // Update Student Details
    public void updateStudent(int id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("\nStudent updated successfully.");
                return;
            }
        }
        System.out.println("\nStudent with ID " + id + " not found. Cannot update.");
    }

    // Delete Student
    public void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("\nStudent deleted successfully.");
                return;
            }
        }
        System.out.println("\nStudent with ID " + id + " not found. Cannot delete.");
    }
}
