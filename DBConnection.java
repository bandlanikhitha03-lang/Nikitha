package com.example.util;
import java.sql.*;
public class DBConnection {
 private static final String URL="jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC";
 private static final String USER="root";
 private static final String PASSWORD="your_password";
 private DBConnection(){}
 public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL,USER,PASSWORD); }
}
