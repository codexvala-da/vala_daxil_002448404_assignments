/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        // Creating a new Department
        Department department = new Department("Information Systems");
        
        // Creating course catalog for a department
        CourseCatalog coursecatalog = department.getCourseCatalog();
        
        
        // Creating electives under couse catalog
        for (int i = 0; i < 10; i++) {
            String courseName = "Course " + i;
            String courseCode = "CODE" + (1000 + i); // Generates codes like CODE1001, CODE1002, etc.
    
            coursecatalog.newCourse(courseName, courseCode, 4, i==0);
        }
        
        // Checking correct execution of course creation
        System.out.println("Courses created under course catalog: ");
        for (Course course : coursecatalog.getCourseList()) {
            System.out.println(course);
        }
                
        // Fetching person directory from department
        PersonDirectory pd = department.getPersonDirectory();
        
        ArrayList<FacultyProfile> faculties;
        faculties = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
        // Creating a new person for making a faculty profile
        Person person_as_faculty = pd.newPerson("Faculty_"+Integer.toString(i));
        // Creating a new faculty profile
        FacultyDirectory fd = department.getFacultyDirectory();
        FacultyProfile faculty = fd.newFacultyProfile(person_as_faculty);
        faculties.add(faculty);
        }
        
        // Creating new course schedule
        CourseSchedule courseschedule = department.newCourseSchedule("Fall 2024");
        
        // Creating new course schedule
        CourseSchedule courseschedule2 = department.newCourseSchedule("Spring 2025");

        
        // Array to store course for schedule 1
        ArrayList<CourseOffer> courseOffersSchedule1;
        courseOffersSchedule1 = new ArrayList<>();
        
        
        for(int i=0; i<5; i++){
            CourseOffer courseOffer = courseschedule.newCourseOffer("CODE" + (1000 + i));
            courseOffer.AssignAsTeacher(faculties.get(i));
            courseOffer.generatSeats(100);
            courseOffersSchedule1.add(courseOffer);
        }
        
        // Array to store courses for schedule 2
        ArrayList<CourseOffer> courseOffersSchedule2;
        courseOffersSchedule2 = new ArrayList<>();
        
        // Creating a new course offer for course schedule 2
        for(int i=5; i<10; i++){
            CourseOffer courseOffer = courseschedule.newCourseOffer("CODE" + (1000 + i));
            courseOffer.AssignAsTeacher(faculties.get(i));
            courseOffer.generatSeats(100);
            courseOffersSchedule2.add(courseOffer);
        }
        
        
        // Checking the course exists for course offer created
        for(CourseOffer course : courseOffersSchedule1){
            if (course==null)return;
        }
        for (CourseOffer course : courseOffersSchedule2){
            if (course==null)return;
        }
        
        
        // Creating a new person and student profiles
        ArrayList<StudentProfile> students;
        students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        Person person = pd.newPerson("Student_"+Integer.toString(i));
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        students.add(student);
        }
        
        // Creating a new course load semester for a student
        for(int i = 0; i < students.size(); i++) {
            Random rand = new Random();

            CourseLoad courseload1 = students.get(i).newCourseLoad("Fall2024");
            CourseLoad courseload2 = students.get(i).newCourseLoad("Spring2025");

            // Register each student for all courses in schedule 1
            for (CourseOffer courseOffer : courseOffersSchedule1) {
                SeatAssignment sa = courseload1.newSeatAssignment(courseOffer);
                sa.setGrade(rand.nextFloat() * 4.0f);
            }

            // Register each student for all courses in schedule 2
            for (CourseOffer courseOffer : courseOffersSchedule2) {
                SeatAssignment sa = courseload2.newSeatAssignment(courseOffer);
                sa.setGrade(rand.nextFloat() * 4.0f);
            }
        }
        
        // Printing report for semester Fall2024
        StudentDirectory student_directory = department.getStudentDirectory();
    }

}
