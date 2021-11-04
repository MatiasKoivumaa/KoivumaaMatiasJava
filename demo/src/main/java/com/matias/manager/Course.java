package com.matias.manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    
    private String courseName;
    private String teacherName;
    private List<Student> students = new ArrayList<>();
    private long id;
    private static long idCounter;

    public Course() {
        this("", "", new ArrayList<>());
    }

    public Course(String courseName, String teacherName, List<Student> students) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.students = students;
        this.id = idCounter++;
    }

    public boolean addStudent(Student student)
    {
        this.students.add(student);
        return true;
    }

    public void removeStudent(Student student)
    {
        this.students.remove(student);
    }

    public List<Student> getStudentList()
    {
        return new ArrayList<Student>(this.students);
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public long getId() {
        return this.id;
    }
}
