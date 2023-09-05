import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private long id;
    private String boss;

    ArrayList<Student> students;

    public Department() {
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }
}
