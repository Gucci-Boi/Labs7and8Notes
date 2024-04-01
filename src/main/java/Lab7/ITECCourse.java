package Lab7;

import java.util.LinkedList;
import java.util.List;

public class ITECCourse {
    // initialized fields/variables
    private String name;
    private int code;
    private List<String> students;
    private int maxStudents;

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents < 0) {
            return;
        }
        this.maxStudents = maxStudents;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructor
    public ITECCourse(String courseName, int courseCode, int courseMaxStudents) {
        name = courseName;
        code = courseCode;
        maxStudents = courseMaxStudents;
        students = new LinkedList<>();
    }
    // adds the student's name to the students list
    public void addStudent(String studentName) {
        if (students.size() == maxStudents) {
            System.out.println("Course is full, can't add " + studentName);
        } else {
            students.add(studentName);
        }
    }

    public void writeCourseInfo() {
        System.out.println("Course name: " + name);
        System.out.println("Course code: " + code);
        System.out.println("Students enrolled: ");
        for (String student: students) {
            System.out.println(student);
        }
        System.out.println("There are " + getNumberOfStudents() + " students enrolled.");
        System.out.println("The max number of students that can enroll in this course is: " + maxStudents);
    }

    public int getNumberOfStudents() {
        return students.size();
    }
    // removes a student from the list
    public void removeStudent(String studentName) {
        if (students.contains(studentName)) {
            students.remove(studentName);
            System.out.println(studentName + " was un-enrolled from " + name);
        } else {
            System.out.println(studentName + " was not found in " + name);
        }
    }
}
