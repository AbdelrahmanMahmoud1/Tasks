import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost","Company","postgres","@Postgres123");
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();

            /*
            * These queries to make the tables in the database and populate it with some data
            * after these queries the task requirements are accomplished
            * you just need to create a database with name company
            * and add the JDBC postgrsql driver in the project path
            * this link will help to add the driver
            * https://stackoverflow.com/questions/854264/how-to-add-directory-to-classpath-in-an-application-run-profile-in-intellij-idea
            * and this is the link to download the driver
            * https://jdbc.postgresql.org/download/
            *
            * you need only to run the queries once
            * */

            String sql;
            sql = "CREATE TABLE IF NOT EXISTS Student (id SERIAL PRIMARY KEY NOT NULL , name TEXT, age INT, grade INT ,  faculty_serial_number INT UNIQUE  )";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS Departments (name TEXT  , id SERIAL PRIMARY KEY NOT NULL , Boss TEXT  )";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS students_departments (ID  SERIAL PRIMARY KEY,student_id INT REFERENCES Student(Id) ON DELETE CASCADE, department_id INT REFERENCES Departments(id) ON DELETE CASCADE)";
            statement.executeUpdate(sql);



            sql = "INSERT INTO Student (Id,name,age,grade,faculty_serial_number) VALUES (1,'Abdelrahman',20,90,123456)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Student (Id,name,age,grade,faculty_serial_number) VALUES (2,'Sarah',21,85,123457)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Student (Id,name,age,grade,faculty_serial_number) VALUES (3,'Mike',22,80,123458)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Student (Id,name,age,grade,faculty_serial_number) VALUES (4,'Ahmed',22,80,1234582)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Departments (name,id,Boss) VALUES ('Computer Engineering',1,'Dr. Smith')";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Departments (name,id,Boss) VALUES ('Mathematics',2,'Dr. Brown')";
            statement.executeUpdate(sql);
            sql = "INSERT INTO Departments (name,id,Boss) VALUES ('Physics',3,'Dr. Johnson')";
            statement.executeUpdate(sql);
            sql = "INSERT INTO students_departments(student_id, department_id) VALUES(1, 1)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO students_departments(student_id, department_id) VALUES(2, 2)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO students_departments(student_id, department_id) VALUES(3, 3)";
            statement.executeUpdate(sql);


            StudentDAO studentDAO = new StudentDAO(connection);
            DepartmentDAO departmentDAO = new DepartmentDAO(connection);

            System.out.println("Find all students: \n");
            System.out.println(studentDAO.findAll());

            System.out.println("Select all students in certain department \n");
            departmentDAO.selectAllFromInSpecificDepartment("Computer Engineering");

            System.out.println("Find by Id then update the student info: ");
            Student student = studentDAO.findById(2);
            System.out.println(student);
            student.setName("Kariem Mohamed");
            studentDAO.update(student);
            System.out.println("Student after update\n");
            System.out.println(studentDAO.findById(2));
            studentDAO.delete(2);

            System.out.println("Count of students that are in department\n");
            System.out.println(departmentDAO.countOfStudentsInDepartments());

            System.out.println("List all students that aren't in department");
            departmentDAO.getAllStudentsWithoutDepartment();


        }catch(SQLException e){
            e.printStackTrace();
        }


        }
    }







//            System.out.println("Select all students:");
//            ResultSet rs = statement.executeQuery("SELECT * FROM Student");
//            while (rs.next()) {
//                System.out.println(rs.getInt("Id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getInt("grade") + "\t" + rs.getString("department") + "\t" + rs.getInt("faculty_serial_number"));
//            }
//
//            // Select all students in specific department by inner join
//            System.out.println("\nSelect all students in specific department by inner join:");
//            rs = statement.executeQuery("SELECT * FROM Student INNER JOIN students_departments ON Student.Id=students_departments.student_id INNER JOIN Departments ON Departments.id=students_departments.department_id WHERE Departments.name='Computer Science'");
//            while (rs.next()) {
//                System.out.println(rs.getInt("Id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getInt("grade") + "\t" + rs.getString("department") + "\t" + rs.getInt("faculty_serial_number"));
//            }

// Update student info by Id
//            System.out.println("\nUpdate student info by Id:");
//            sql = "UPDATE Student SET grade=95 WHERE Id=1";
//            int rowsAffected = statement.executeUpdate(sql);


// Get count of students in departments
//            System.out.println("\nGet count of students in departments:");
//            rs = statement.executeQuery("SELECT department, COUNT(*) FROM Student GROUP BY department");
//            while (rs.next()) {
//                System.out.println(rs.getString("department") + "\t" + rs.getInt("count"));
//            }
//
//            // List all students that have no departments
//            System.out.println("\nList all students that have no departments:");
//            rs = statement.executeQuery("SELECT * FROM Student WHERE Id NOT IN (SELECT student_id FROM students_departments)");
//            while (rs.next()) {
//                System.out.println(rs.getInt("Id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getInt("grade") + "\t" + rs.getString("department") + "\t" + rs.getInt("faculty_serial_number"));
//            }
