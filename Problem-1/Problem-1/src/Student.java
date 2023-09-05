import java.util.ArrayList;

public class Student {
    private long id;
    private String name;
    private int age;
    private double grade;
    private long facultySerialNumber;
    private ArrayList<String> departments;

    public ArrayList<String> getDepartments() {
        return departments;
    }

    public void setDepartments(String department) {
        departments.add(department);
    }

    public void removeDepartment(String department){
        departments.remove(department);
    }
    public Student() {
        departments = new ArrayList<String>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public long getFacultySerialNumber() {
        return facultySerialNumber;
    }

    public void setFacultySerialNumber(long facultySerialNumber) {
        this.facultySerialNumber = facultySerialNumber;
    }

    public Student(long id, String name, int age, double grade, long facultySerialNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.facultySerialNumber = facultySerialNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", department='" + departments + '\'' +
                ", facultySerialNumber=" + facultySerialNumber +
                ", departments=" + departments +
                '}';
    }
}
