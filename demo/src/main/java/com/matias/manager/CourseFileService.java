package com.matias.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseFileService implements ICourseFileService {
    
    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException
    {   
        File studentFile = new File(filePath);
        Scanner sc = new Scanner(studentFile);
        List<Student> studentsFromFile = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] studentInfo = sc.nextLine().split("---");
            studentsFromFile.add(new Student(studentInfo[0], studentInfo[1]));
        }
        sc.close();
        return studentsFromFile;
    }

    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException
    {
        File courseFile = new File(filePath);
        Scanner sc = new Scanner(courseFile);
        List<Course> coursesFromFile = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] courseInfo = sc.nextLine().split("---");
            if (courseInfo.length == 4) {
                coursesFromFile.add(new OnlineCourse(courseInfo[2], courseInfo[0], courseInfo[1], new ArrayList<>()));
            } else {
                coursesFromFile.add(new LocalCourse(courseInfo[2], courseInfo[0], courseInfo[1], new ArrayList<>()));
            }
        }
        sc.close();
        return coursesFromFile;
    }
}
