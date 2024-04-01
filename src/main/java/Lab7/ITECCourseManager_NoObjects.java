package Lab7;

public class ITECCourseManager_NoObjects {
    public static void main(String[] args) {
        ITECCourse maintenanceCourse = new ITECCourse("Microcomputer System Maintenance", 1310, 20);

        //Add some students.    TODO check that we have not exceeded the max number for the class
        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");
        maintenanceCourse.removeStudent("Carl");
        maintenanceCourse.removeStudent("Martha");

        maintenanceCourse.writeCourseInfo();

        ITECCourse datacomCourse = new ITECCourse("Data Communication", 1425, 30);

        //Add some students
        datacomCourse.addStudent("Dave");
        datacomCourse.addStudent("Ed");
        datacomCourse.addStudent("Flora");

        datacomCourse.writeCourseInfo();

        //
        ITECCourse softwareDevProjects = new ITECCourse("Software Development Projects", 2983, 24);
        softwareDevProjects.addStudent("Gus");
        softwareDevProjects.addStudent("Carl");
        softwareDevProjects.addStudent("Larry");

        int totalEnrolled = softwareDevProjects.getNumberOfStudents();
        System.out.println("The " + softwareDevProjects.getName() + " class has " + totalEnrolled + " students.");
        System.out.println("ITEC " + softwareDevProjects.getCode() + " " + softwareDevProjects.getName());

        softwareDevProjects.setMaxStudents(30);
        softwareDevProjects.writeCourseInfo();

        ITECCourse smallCourse = new ITECCourse("Made up course", 1234, 3);
        smallCourse.addStudent("Kirby");
        smallCourse.addStudent("Liam");
        smallCourse.addStudent("Miriam");
        smallCourse.addStudent("Nita");

        smallCourse.removeStudent("Kirby");

        smallCourse.writeCourseInfo();
    }
}
