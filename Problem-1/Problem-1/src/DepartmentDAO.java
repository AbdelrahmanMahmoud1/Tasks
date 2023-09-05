import DAO.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends DataAccessObject<Department> {

    private static final String SPECIFIC_DEPARTMENT =  "SELECT * FROM Student INNER JOIN students_departments ON Student.Id=students_departments.student_id INNER JOIN Departments ON Departments.id=students_departments.department_id WHERE Departments.name= ?";
    private static final String GET_ALL_WITHOUT_DEPARTMENT = "SELECT * FROM Student WHERE Id NOT IN (SELECT student_id FROM students_departments)";
    public DepartmentDAO(Connection connection) {
        super(connection);
    }



    public void selectAllFromInSpecificDepartment(String departmentName){

        try(PreparedStatement statement = this.connection.prepareStatement(SPECIFIC_DEPARTMENT)) {
            statement.setString(1,departmentName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getInt("grade") + "\t" +  "\t" + rs.getInt("faculty_serial_number"));
            }

        }catch (SQLException e){
    e.printStackTrace();
            }

    }
    public int countOfStudentsInDepartments(){
        int count = 0;
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT COUNT ( DISTINCT student_id ) FROM students_departments");
            while (rs.next()) {
              count =   rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<Student> getAllStudentsWithoutDepartment(){
        ArrayList<Student> students = new ArrayList<Student>();;
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM Student WHERE Id NOT IN (SELECT student_id FROM students_departments)");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getInt("grade") + "\t"  + "\t" + rs.getInt("faculty_serial_number"));
                students.add(new Student(rs.getInt("Id"), rs.getString("name"), rs.getInt("age"),rs.getInt("grade"), rs.getInt("faculty_serial_number")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
       return students;
    }
    @Override
    public Department findById(long id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department update(Department dto) {
        return null;
    }

    @Override
    public Department create(Department dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
