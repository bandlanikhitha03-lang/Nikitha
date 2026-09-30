package com.example.model;
public class Student {
 private int id, age; private String name, email, course;
 public Student() {}
 public Student(int id,String name,String email,String course,int age){this.id=id;this.name=name;this.email=email;this.course=course;this.age=age;}
 public int getId(){return id;} public void setId(int id){this.id=id;}
 public int getAge(){return age;} public void setAge(int age){this.age=age;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
 public String getCourse(){return course;} public void setCourse(String course){this.course=course;}
}
