package com.example.dao;
import com.example.model.Student; import com.example.util.DBConnection; import java.sql.*; import java.util.*;
public class StudentDAO {
 public List<Student> findAll() throws SQLException { List<Student> list=new ArrayList<>(); String q="SELECT * FROM students ORDER BY id DESC"; try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(q); ResultSet r=p.executeQuery()){while(r.next())list.add(map(r));} return list; }
 public Student findById(int id) throws SQLException {String q="SELECT * FROM students WHERE id=?"; try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(q)){p.setInt(1,id);try(ResultSet r=p.executeQuery()){return r.next()?map(r):null;}}}
 public void insert(Student s) throws SQLException {String q="INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){set(p,s);p.executeUpdate();}}
 public void update(Student s) throws SQLException {String q="UPDATE students SET name=?,email=?,course=?,age=? WHERE id=?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){set(p,s);p.setInt(5,s.getId());p.executeUpdate();}}
 public void delete(int id) throws SQLException {String q="DELETE FROM students WHERE id=?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){p.setInt(1,id);p.executeUpdate();}}
 private void set(PreparedStatement p,Student s)throws SQLException{p.setString(1,s.getName());p.setString(2,s.getEmail());p.setString(3,s.getCourse());p.setInt(4,s.getAge());}
 private Student map(ResultSet r)throws SQLException{return new Student(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("course"),r.getInt("age"));}
}
