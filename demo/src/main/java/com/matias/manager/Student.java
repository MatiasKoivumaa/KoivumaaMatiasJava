package com.matias.manager;

public class Student {
    
    private String firstName;
    private String lastName;
    private long id;
    private static long idCounter = 0;

    public Student() {
        this("", "");
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = idCounter++;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString()
    {
        return this.lastName+" "+this.firstName;
    }
}
