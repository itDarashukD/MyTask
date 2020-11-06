package ProjectEmployer.DAO;

import ProjectEmployer.Entity.Adress;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

    //create
    public void add(Adress adress) throws SQLException;

    //read
    public List<Adress> readAllAdress() throws SQLException;

    public Adress readOneAdress(Long id) throws SQLException;

    //update
    public void update(Adress adress) throws SQLException;

    //delete
    public void remove(Adress adress) throws SQLException;

}
