package com.example.service;
import com.example.dao.StudentDAO; import com.example.model.Student; import java.sql.SQLException; import java.util.List;
public class StudentService { private final StudentDAO dao=new StudentDAO();
 public List<Student> getAll() throws SQLException{return dao.findAll();} public Student get(int id)throws SQLException{return dao.findById(id);}
 public void save(Student s)throws SQLException{validate(s);if(s.getId()==0)dao.insert(s);else dao.update(s);} public void delete(int id)throws SQLException{dao.delete(id);}
 private void validate(Student s){if(s.getName()==null||s.getName().isBlank())throw new IllegalArgumentException("Name is required");if(s.getEmail()==null||!s.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))throw new IllegalArgumentException("Valid email is required");if(s.getAge()<1||s.getAge()>120)throw new IllegalArgumentException("Age must be between 1 and 120");}
}
