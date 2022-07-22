package chapter13.ex13;

/**
 * @author swarfte
 * @title Enable the Course class cloneable
 */
public class Ch13Ex13 {
    public static void main(String[] args) throws Exception {

    }
}

/**
 * UML diagram:
 * <p>
 * Course implements Cloneable
 * <p>
 * - courseNumber: String
 * <p>
 * - students: String[]
 * <p>
 * - numberOfStudents: int
 * <p>
 * + Course(courseNumber: String)
 * <p>
 * + getCourseNumber(): String
 * <p>
 * + getStudents(): String[]
 * <p>
 * + dropStudent(student: String): void
 * <p>
 * + getStudents(): String[]
 * <p>
 * + getNumberOfStudents(): int
 * <p>
 * + clone(): Course
 */
class Course implements Cloneable {
    private String courseNumber;
    private String[] students;
    private int numberOfStudents;

    public Course(String courseNumber) {
        this.courseNumber = courseNumber;
        students = new String[10];
        numberOfStudents = 0;
    }

    public String getCourseName() {
        return courseNumber;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                numberOfStudents--;
                break;
            }
        }
    }

    public String[] getStudents() {
        String[] students = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = this.students[i];
        }
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Course clone() {
        Course course = new Course(courseNumber);
        for (int i = 0; i < numberOfStudents; i++) {
            course.addStudent(students[i]);
        }
        return course;
    }
}