package com.example.student_management;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;
    private String course;

    public Student() {}

    public Student(String name, int age, String email, String course) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCourse() { return course; }  // ✅ Corrected
    public void setCourse(String course) { this.course = course; }  // ✅ Corrected
}
