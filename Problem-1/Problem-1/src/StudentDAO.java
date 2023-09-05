import DAO.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DataAccessObject<Student> {

    public StudentDAO(Connection connection) {
        super(connection);
    }

    //sql = "INSERT INTO Student (Id,name,age,grade,department,faculty_serial_number) VALUES (1,'John',20,90,'Computer Science',123456)";
    private static final String INSERT = "INSERT INTO STUDENT (Id,name,age,grade,faculty_serial_number) +" +
            " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT Id, name, age, " +
            "grade, faculty_serial_number FROM STUDENT WHERE Id=?";

    private static final String UPDATE = "UPDATE STUDENT SET name = ?, age=?, " +
            "grade = ?, faculty_serial_number = ? WHERE Id = ?";

    private static final String DELETE = "DELETE FROM STUDENT WHERE Id = ?";

    private static final String GET_ALL = "SELECT * FROM STUDENT";



    @Override
    public Student findById(long id) {
        Student student = new Student();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                student.setId(rs.getLong("Id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGrade(rs.getLong("grade"));
                student.setFacultySerialNumber(rs.getLong("faculty_serial_number"));

            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {

      List<Student> students = new ArrayList<Student>();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL);){

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getLong("Id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGrade(rs.getLong("grade"));
                student.setFacultySerialNumber(rs.getLong("faculty_serial_number"));
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student update(Student dto) {


        Student student = null;

        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getName());
            statement.setInt(2, dto.getAge());
            statement.setDouble(3, dto.getGrade());
            statement.setLong(4, dto.getFacultySerialNumber());
            statement.setLong(5, dto.getId());
            statement.execute();

            student = this.findById(dto.getId());
        }catch(SQLException e){

            e.printStackTrace();

        }
        return student;

    }

    @Override
    public Student create(Student dto) {
        return null;
    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
            statement.setLong(1, id);
            statement.execute();
            System.out.println("Deleted successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
