# Student Management - Java MVC + JDBC + MySQL

## Technologies
- Frontend: HTML/JSP, CSS, JavaScript
- Backend: Java Servlet (MVC)
- Database access: JDBC + PreparedStatement
- Database: MySQL
- Build/dependency: Maven
- Server: Tomcat 10.1+
- JDK: 17+

## Architecture
Browser -> StudentServlet (Controller) -> StudentDAO (JDBC) -> MySQL
                         |-> Student model
                         |-> students.jsp (View)

## Setup
1. Install JDK 17+, Maven, MySQL, and Tomcat 10.1+.
2. Run `database.sql` in MySQL.
3. Open `src/main/java/com/example/util/DBConnection.java` and change `PASSWORD` (and USER if needed).
4. In the project folder run: `mvn clean package`.
5. Deploy `target/student-management.war` to Tomcat's `webapps` folder.
6. Start Tomcat and open: `http://localhost:8080/student-management/students`

## CRUD
- Create: form -> POST -> DAO.save()
- Read: GET -> DAO.findAll() -> JSP
- Update: DAO.update() is included; an edit form can be added next.
- Delete: Delete link -> DAO.delete()

## Important
Do not commit real database passwords to GitHub. For a real application, use environment variables or a secrets manager.
