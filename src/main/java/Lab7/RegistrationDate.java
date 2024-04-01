package Lab7;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Student {
    String name;
    Date registrationDate;
    public Student(String name) {
        this.name = name;
        this.registrationDate = new Date();
    }
}

public class RegistrationDate {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("A");
        students.add(student1);
        Student student2 = new Student("B");
        students.add(student2);

        for (Student s: students) {
            System.out.println(s.name + " registered at " + s.registrationDate);
        }
    }
}
