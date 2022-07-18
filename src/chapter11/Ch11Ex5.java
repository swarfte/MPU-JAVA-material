package chapter11;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title The Course class
 */
public class Ch11Ex5 {
    public static void main(String[] args) {

    }
}

/**
 * UML diagram
 * <p>
 * Course
 * <p>
 * - courseName: String
 * <p>
 * - students: ArrayList<String>
 * <p>
 * - numberOfStudents: int
 * <p>
 * + Course(String courseName)
 * <p>
 * + getCourseName(): String
 * <p>
 * + addStudent(String student): void
 * <p>
 * + dropStudent(String student): void
 * <p>
 * + getStudents(): ArrayList<String>
 * <p>
 * + getNumberOfStudents(): int
 */

class Course {
    private String courseName;
    private ArrayList<String> students;
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<String>();
        numberOfStudents = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        students.remove(student);
        numberOfStudents--;
    }

    public ArrayList<String> getStudents() {
        return students;
    }
}
