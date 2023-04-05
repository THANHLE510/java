package JAVA_2.SQL.EXAM.ThucHanhJava2.src.Thanh.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> studentList = new ArrayList<>();
    public void run() {
        while (true) {
            displayMenu();
            int option = getOption();
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    saveStudents();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public void displayMenu() {
        System.out.println("\n----------File Student----------");
        System.out.println("1. Add student records");
        System.out.println("2. Display student records");
        System.out.println("3. Save");
        System.out.println("4. Exit");
    }

    public int getOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter option: ");
        return scanner.nextInt();
    }

    public void addStudent() {
        System.out.println("\n-----Add student records-----");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentID = scanner.next();

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter address: ");
        String address = scanner.next();

        System.out.print("Enter phone: ");
        String phone = scanner.next();

        Student student = new Student(studentID, name, address, phone);
        studentList.add(student);
        System.out.println("Đã thêm sinh viên vào danh sách chờ");
    }

    public void displayStudents() {
        System.out.println("\n-----Display student records-----");
        System.out.println("Student ID\t\tName\tAddress\tPhone");
        for (Student student : studentList) {
            System.out.println(student.getStudentID() + "\t\t" + student.getName() + "\t" + student.getAddress() + "\t\t" + student.getPhone());
        }
    }

    public void saveStudents() {
        for (Student student : studentList) {
            try(
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/file_student", "root", "");
                    ){
                PreparedStatement pstmt = conn.prepareStatement("insert into student values (?,?,?,?)");

                pstmt.setString(1,student.getStudentID());
                pstmt.setString(2,student.getName());
                pstmt.setString(3,student.getAddress());
                pstmt.setString(4,student.getPhone());

                int check = pstmt.executeUpdate();
                if(check >= 1 ){
                    System.out.println("Update roi");
                } else {
                    System.out.println("Update roi");
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
        studentList.clear();
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.run();
    }
}

class Student {
    private String studentID;
    private String name;
    private String address;
    private String phone;

    public Student(String studentID, String name, String address, String phone) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    public String toString(){
        return "Student ID: " + studentID + ", Name: " + name + ", Address: " + address + ", Phone: " + phone;
    }

}
