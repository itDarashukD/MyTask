package AllTasks;


import java.text.SimpleDateFormat;
import java.util.Date;

@Author(name = "Dima", date = 2020)
public class Task4 {
    private String name;
    private int id;

    public Task4() {
        this.name = "noName";
        this.id = -1;
    }

    public Task4 (String name, int id) {
        this.name = name;
        this.id = id;
    }


    public void hello() {
        System.out.println("hello  efsfes+fsefesf+fsef+fsfs");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}





