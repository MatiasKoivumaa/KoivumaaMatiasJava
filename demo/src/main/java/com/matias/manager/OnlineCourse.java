package com.matias.manager;

import java.util.List;

public class OnlineCourse extends Course {

    private String courseURL;

    public OnlineCourse(String courseURL, String courseName, String teacherName, List<Student> students) {
        super(courseName, teacherName, students);
        this.courseURL = courseURL;
    }

    public String getCourseURL() {
        return this.courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }

    @Override
    public String toString()
    {
        return getCourseName()+" - "+getTeacherName()+" - "+this.courseURL;
    }
}
