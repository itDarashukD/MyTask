package ProjectEmployer.DAO;

import ProjectEmployer.Entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    //create
    public void add(Project project) throws SQLException;

    //read
    public List<Project> readAllProject() throws SQLException;


    public Project readOneProjct(Long id) throws SQLException;

    //update
    public void update(Project project) throws SQLException;

    //delete
    public void delete(Project project) throws SQLException;
}
