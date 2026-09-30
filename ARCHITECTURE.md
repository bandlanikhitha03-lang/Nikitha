# Architecture
Frontend (JSP/CSS/JS) -> StudentServlet (Controller) -> StudentService -> StudentDAO -> JDBC -> MySQL.

MVC:
- Model: Student.java
- View: JSP files
- Controller: StudentServlet.java

DAO isolates SQL/database access; Service contains validation/business rules.
