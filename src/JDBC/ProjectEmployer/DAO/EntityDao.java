package JDBC.ProjectEmployer.DAO;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T> {
    void add(T entity) throws SQLException;
    T getById(Long id) throws SQLException;
    List<T> getAll() throws SQLException;
    Boolean update(T entity) throws SQLException;
    Boolean remove(T entity) throws SQLException;





}
