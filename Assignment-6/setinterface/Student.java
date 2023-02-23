package Setinterface;

import java.util.*;

class Student {
    private int studentId;
    private String studentName;
    private String emailId;

    public Student(int studentId, String studentName, String emailId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.emailId = emailId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmailId() {
        return emailId;
    }
}

class Tester {
    public static Set<Student> findUnique(List<Student> students) {
        Set<String> emailSet = new HashSet<>();
        Set<Student> uniqueStudents = new HashSet<>();
        
        for (Student student : students) {
            if (!emailSet.contains(student.getEmailId())) {
                emailSet.add(student.getEmailId());
                uniqueStudents.add(student);
            }
        }
        
        return uniqueStudents;
    }

    public static Set<Student> findDuplicates(List<Student> students) {
        Set<String> emailSet = new HashSet<>();
        Set<Student> duplicateStudents = new HashSet<>();
        
        for (Student student : students) {
            if (emailSet.contains(student.getEmailId())) {
                duplicateStudents.add(student);
            } else {
                emailSet.add(student.getEmailId());
            }
        }
        
        return duplicateStudents;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "alice@example.com"));
        students.add(new Student(2, "Bob", "bob@example.com"));
        students.add(new Student(3, "Charlie", "charlie@example.com"));
        students.add(new Student(4, "David", "david@example.com"));
        students.add(new Student(5, "Eve", "eve@example.com"));
        students.add(new Student(6, "Frank", "frank@example.com"));
        students.add(new Student(7, "Alice", "alice@example.com"));
        students.add(new Student(8, "Charlie", "charlie@example.com"));

        Set<Student> uniqueStudents = findUnique(students);
        System.out.println("Unique students:");
        for (Student student : uniqueStudents) {
            System.out.println(student.getStudentId() + " " + student.getStudentName() + " " + student.getEmailId());
        }

        Set<Student> duplicateStudents = findDuplicates(students);
        System.out.println("Duplicate students:");
        for (Student student : duplicateStudents) {
            System.out.println(student.getStudentId() + " " + student.getStudentName() + " " + student.getEmailId());
        }
    }
}
