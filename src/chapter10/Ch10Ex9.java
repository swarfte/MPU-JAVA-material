package chapter10;

import java.util.Arrays;

/**
 * @author swarfte
 * @title The Course class
 */
public class Ch10Ex9 {
    public static void main(String[] args) {
        Course course = new Course("Java Programming");
        course.addStudent("a");
        course.addStudent("b");
        course.addStudent("c");
        course.dropStudent("b");
        System.out.println(Arrays.toString(course.getStudents()));
    }
}

/**
 * UML diagram
 * <p>
 * Course
 * <p>
 * - courseName: String
 * <p>
 * - students: String[]
 * <p>
 * - numberOfStudents: int
 * <p>
 * + Course(courseName: String)
 * <p>
 * + getCourseName(): String
 * <p>
 * + addStudent(student: String): void
 * <p>
 * + dropStudent(student: String): void
 * <p>
 * + getStudents(): String[]
 * <p>
 * + getNumberOfStudents(): int
 */

class Course {
    private String courseName;
    private String[] students = new String[1];
    private int numberOfStudents = 0;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String students) {
        if (numberOfStudents >= this.students.length) {
            String[] temp = new String[this.students.length * 2];
            System.arraycopy(this.students, 0, temp, 0, this.students.length);
            this.students = temp;
        }

        this.students[numberOfStudents] = students;
        numberOfStudents++;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String[] getStudents() {
        String[] temp = new String[numberOfStudents];
        System.arraycopy(students, 0, temp, 0, numberOfStudents);
        return temp;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                // shift all elements after the dropped student to the left
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                numberOfStudents--;
            }
        }
    }

    public void clear() {
        students = new String[1];
        numberOfStudents = 0;
    }
}
