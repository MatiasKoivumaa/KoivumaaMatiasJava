package com.matias.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("students")
    public List<Student> getStudents()
    {
        return courseService.getStudents();
    }

    @GetMapping("courses")
    public List<Course> getCourses()
    {
        return courseService.getCourses();
    }

    @GetMapping("onlinecourses")
    public String getOnlineCourses()
    {
        List<String> onlineCourseNames = new ArrayList<>();

        for (Course course : courseService.getCourses()) {
            if (course instanceof OnlineCourse) {
                onlineCourseNames.add(course.getCourseName());
            }
        }
        return String.join("<br>", onlineCourseNames);
    }

    @GetMapping("students/{id}")
    public String getStudentById(@PathVariable Long id)
    {
        Student student = courseService.getStudentById(id);
        List<String> studentsCourseNames = new ArrayList<>();

        for (Course course : courseService.getCoursesOfStudent(id)) {
            studentsCourseNames.add(course.getCourseName());
        }
        return "<h2>"+student.getFirstName()+" "+student.getLastName()+"</h2>"+"<br>"+String.join("<br>", studentsCourseNames);
    }

    @GetMapping("courses/{id}")
    public String getCourseById(@PathVariable Long id)
    {
        Course course = courseService.getCourseById(id);
        List<String> coursesStudentNames = new ArrayList<>();

        for (Student student : course.getStudentList()) {
            coursesStudentNames.add(student.getFirstName()+" "+student.getLastName());
        }
        return "<h2>"+course.getCourseName()+"</h2>"+"<br>"+String.join("<br>", coursesStudentNames);
    }

    @PostMapping("add")
    public boolean addStudentToCourse(@RequestBody Map<String, Long> jsonMapping)
    {
        return courseService.addStudentToCourse(jsonMapping.get("sid"), jsonMapping.get("cid"));
    }
}
