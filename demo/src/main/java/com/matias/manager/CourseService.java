package com.matias.manager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {

    public List<Student> students = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();

    public CourseService() throws FileNotFoundException
    {
        CourseFileService courseFileService = new CourseFileService();
        this.courses = courseFileService.readCoursesFromFile("./courses.txt");
        this.students = courseFileService.readStudentsFromFile("./students.txt");
        
    }
    
    public List<Student> getStudents()
    {
        return this.students;
    }

    public List<Course> getCourses()
    {
        return this.courses;
    }

    public Student getStudentById(long studentId)
    {
        List<Student> foundStudent = new ArrayList<>();

        for (Student student : this.students) {
            if (student.getId() == studentId) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            foundStudent.add(null);
        }
        return foundStudent.get(0);
    }

    public Course getCourseById(long courseId)
    {
        List<Course> foundCourse = new ArrayList<>();

        for (Course course: this.courses) {
            if (course.getId() == courseId) {
                foundCourse.add(course);
            }
        }
        if (foundCourse.isEmpty()) {
            foundCourse.add(null);
        }
        return foundCourse.get(0);
    }

    public List<Course> getCoursesOfStudent(long studentId)
    {
        List<Course> studentCourses = new ArrayList<>();

        for (Course course : this.courses) {
            for (Student student : course.getStudentList()) {
                if (student.getId() == studentId) {
                    studentCourses.add(course);
                }
            }
        }
        return studentCourses;
    }

    public boolean addStudentToCourse(long studentId, long courseId)
    {
        return this.getCourseById(courseId).addStudent(this.getStudentById(studentId));
    }
}
