package com.course.main;

import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;
import com.course.model.Course;
import com.course.model.Student;
import com.course.service.CourseService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseService courseService = new CourseService();

        System.out.println("1. Add a Course");
        System.out.println("2. Enroll a Student");
        System.out.println("3. View Courses");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        if (choice == 1) {

            System.out.print("Enter Course ID: ");
            int courseId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course Name: ");
            String courseName = sc.nextLine();

            System.out.print("Enter Max Seats: ");
            int maxSeats = sc.nextInt();

            Course course = new Course(courseId, courseName, maxSeats);
            courseService.addCourse(course);

        } else if (choice == 2) {

            System.out.print("Enter Course ID to enroll in: ");
            int enrollCourseId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String studentName = sc.nextLine();

            Student student = new Student(studentId, studentName);

            try {
                courseService.enrollStudent(enrollCourseId, student);
            } catch (CourseNotFoundException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (CourseFullException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } else if (choice == 3) {

            courseService.viewCourses();

        } else {

            System.out.println("Invalid choice. Please enter 1-3.");
        }

        sc.close();
    }
}