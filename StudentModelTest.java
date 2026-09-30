package com.example; import com.example.model.Student; import org.junit.Test; import static org.junit.Assert.*;
public class StudentModelTest { @Test public void testStudent(){Student s=new Student(1,"A","a@b.com","Java",20);assertEquals("A",s.getName());assertEquals(20,s.getAge());} }
