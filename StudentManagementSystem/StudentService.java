import java.util.*;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        students = FileHandler.readStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        FileHandler.writeStudents(students);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            System.out.println(
                s.getId() + " | " + s.getName() + " | " +
                s.getAge() + " | " + s.getCourse()
            );
        }
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            FileHandler.writeStudents(students);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                found = true;
                break;
            }
        }

        if (found) {
            FileHandler.writeStudents(students);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}