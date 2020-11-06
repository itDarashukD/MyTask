package ProjectEmployer.DAO;

import ProjectEmployer.Entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjDao {

    //create
    public void add(EmplProj emplProj) throws SQLException;


    //read
    public List<EmplProj> readAllEmplProj() throws SQLException;

    public EmplProj readOneEmplProjIdAndProjectId(Long employeeID, Long progectId) throws SQLException;


    //update
    public void update(EmplProj emplProj) throws SQLException;


    //delete
    public void delete(EmplProj emplProj) throws SQLException;


}
