package JDBC.ProjectEmployer.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Entity {

    static String password = "dd1152138";
    static String userName = "postgres";
    static String connectionUrl = "jdbc:postgresql://localhost:5432/ProjectEmployer";
    static String driver = "org.postgresql.Driver";

    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName(driver);
        Connection con = null;
        try {
            con = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("connetion is ON");

        return con;


    }

}
