package com.example.dao;

import com.example.model.Student;
import com.example.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> findAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id,name,email,course,age FROM students ORDER BY id DESC";
        try (Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {
            while(rs.next()) list.add(map(rs));
        }
        return list;
    }
    public void save(Student s) throws SQLException {
        String sql="INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,s.getName()); ps.setString(2,s.getEmail()); ps.setString(3,s.getCourse()); ps.setInt(4,s.getAge()); ps.executeUpdate();
        }
    }
    public void update(Student s) throws SQLException {
        String sql="UPDATE students SET name=?,email=?,course=?,age=? WHERE id=?";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1,s.getName()); ps.setString(2,s.getEmail()); ps.setString(3,s.getCourse()); ps.setInt(4,s.getAge()); ps.setInt(5,s.getId()); ps.executeUpdate();
        }
    }
    public void delete(int id) throws SQLException {
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("DELETE FROM students WHERE id=?")) { ps.setInt(1,id); ps.executeUpdate(); }
    }
    private Student map(ResultSet rs) throws SQLException { return new Student(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("course"),rs.getInt("age")); }
}
