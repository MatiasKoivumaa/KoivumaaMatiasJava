package com.matias.manager;

import java.util.List;

public class LocalCourse extends Course {
    
    private String courseClassRoom;

    public LocalCourse(String courseClassRoom, String courseName, String teacherName, List<Student> students) {
        super(courseName, teacherName, students);
        this.courseClassRoom = courseClassRoom;
    }

    public String getCourseClassRoom() {
        return this.courseClassRoom;
    }

    public void setCourseClassRoom(String courseClassRoom) {
        this.courseClassRoom = courseClassRoom;
    }

    @Override
    public boolean addStudent(Student student)
    {
        List<Student> newStudents = super.getStudentList();

        if (newStudents.size() >= 25) {
            return false;
        } else {
            newStudents.add(student);
            super.setStudents(newStudents);
            return true;
        }
    }

    @Override
    public String toString()
    {
        return getCourseName()+" - "+getTeacherName()+" - "+this.courseClassRoom;
    }
}
