package chapter11;

import java.util.GregorianCalendar;

/**
 * @author swarfte
 * @title The Person, Student, Employee, Faculty and Staff classes
 */
public class Ch11Ex2 {
    public static void main(String[] args) {
        Person p = new Person("John", "Macau", "12345678", "abc@efg.com");
        Student s = new Student("Jane", "Doe", "23456789", "fff", Student.FRESHMAN);
        Employee e = new Employee("Joy", "Doe", "34567890", "ccc", "cleaner", 6656, new MyDate());
        Faculty f = new Faculty("Job", "Doe", "45678901", "ddd", "computer science", 10000, new MyDate(), 36, 1);
        Staff st = new Staff("Joe", "Doe", "56789012", "eee", "administrative", 5000, new MyDate(), "janitor");
        System.out.println(p);
        System.out.println(s);
        System.out.println(e);
        System.out.println(f);
        System.out.println(st);
    }
}

/**
 * UML diagram
 * <p>
 * Person
 * <p>
 * # name: String
 * <p>
 * # address: String
 * <p>
 * # phoneNumber: String
 * <p>
 * # email: String
 * <p>
 * + Person()
 * <p>
 * + Person(name: String, address: String, phoneNumber: String, email: String)
 * <p>
 * + getName(): String
 * <p>
 * + getAddress(): String
 * <p>
 * + getPhoneNumber(): String
 * <p>
 * + getEmail(): String
 * <p>
 * + setName(name: String): void
 * <p>
 * + setAddress(address: String):
 * <p>
 * + setPhoneNumber(phoneNumber: String): void
 * <p>
 * + setEmail(email: String): void
 * <p>
 * + toString(): String
 */

class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String email;

    public Person() {
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.email = "";
    }

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "" + this.getClass().getName() + " : " + this.name;
    }
}

/**
 * UML diagram
 * <p>
 * Student extends Person
 * <p>
 * # classStatus: int
 * <p>
 * + FRESHMAN: int = 1 {ReadOnly}
 * <p>
 * ______________________________
 * <p>
 * + SOPHOMORE: int = 2 {ReadOnly}
 * <p>
 * ________________________________
 * <p>
 * + JUNIOR: int = 3 {ReadOnly}
 * <p>
 * _____________________________
 * <p>
 * +  SENIOR: int = 4 {ReadOnly}
 * <p>
 * _____________________________
 * <p>
 * + Student()
 * <p>
 * + Student(name: String, address: String, phoneNumber: String, email: String, classStatus: int)
 * <p>
 * + getClassStatus(): String
 */

class Student extends Person {
    protected int classStatus;
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;

    public Student() {
        super();
        this.classStatus = 1;
    }

    public Student(String name, String address, String phoneNumber, String email, int classStatus) {
        super(name, address, phoneNumber, email);
        this.classStatus = classStatus;
    }

    public String getClassStatus() {
        return switch (this.classStatus) {
            case 1 -> "FRESHMAN";
            case 2 -> "SOPHOMORE";
            case 3 -> "JUNIOR";
            case 4 -> "SENIOR";
            default -> "UNKNOWN";
        };
    }
}

/**
 * UML diagram
 * <p>
 * Employee extends Person
 * <p>
 * # office: String
 * <p>
 * # salary: double
 * <p>
 * # dateHired: MyDate
 * <p>
 * + Employee()
 * <p>
 * + Employee(name: String, address: String, phoneNumber: String, email: String, office: String, salary: double, dateHired: MyDate)
 * <p>
 * + getOffice(): String
 * <p>
 * + getSalary(): double
 * <p>
 * + getDateHired(): MyDate
 * <p>
 * + setOffice(office: String): void
 * <p>
 * + setSalary(salary: double): void
 */

class Employee extends Person {
    protected String office;
    protected double salary;
    protected MyDate dateHired;

    public Employee() {
        super();
        this.office = "";
        this.salary = 0.0;
        this.dateHired = new MyDate();
    }

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary, MyDate dateHired) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return this.office;
    }

    public double getSalary() {
        return this.salary;
    }

    public MyDate getDateHired() {
        return this.dateHired;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


/**
 * UML diagram
 * <p>
 * Faculty extends Employee
 * <p>
 * # officeHours: int
 * <p>
 * # rank: int
 * <p>
 * + Faculty()
 * <p>
 * + Faculty(name: String, address: String, phoneNumber: String, email: String, office: String, salary: double, dateHired: MyDate, officeHours: int, rank: int)
 * <p>
 * + getOfficeHours(): int
 * <p>
 * + getRank(): int
 * <p>
 * + setOfficeHours(officeHours: int): void
 * <p>
 * + setRank(rank: int): void
 */

class Faculty extends Employee {
    protected int officeHours;
    protected int rank;

    public Faculty() {
        super();
        this.officeHours = 0;
        this.rank = 0;
    }

    public Faculty(String name, String address, String phoneNumber, String email, String office, double salary, MyDate dateHired, int officeHours, int rank) {
        super(name, address, phoneNumber, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public int getOfficeHours() {
        return this.officeHours;
    }

    public int getRank() {
        return this.rank;
    }

    public void setOfficeHours(int officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

/**
 * UML diagram
 * <p>
 * Staff extends Employee
 * <p>
 * # title: String
 * <p>
 * + Staff()
 * <p>
 * + Staff(name: String, address: String, phoneNumber: String, email: String, office: String, salary: double, dateHired: MyDate, title: String)
 * <p>
 * + getTitle(): String
 * <p>
 * + setTitle(title: String): void
 */
class Staff extends Employee {
    protected String title;

    public Staff() {
        super();
        this.title = "";
    }

    public Staff(String name, String address, String phoneNumber, String email, String office, double salary, MyDate dateHired, String title) {
        super(name, address, phoneNumber, email, office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    MyDate() {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(long elapsedTime) {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public long setDate(long elapsedTime) {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        return calendar.getTimeInMillis();
    }
}