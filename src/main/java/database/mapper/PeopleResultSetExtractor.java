package database.mapper;

import domain.People;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        People people = new People();
        people.setName(rs.getString(1));
        people.setEmail(rs.getString(2));
        people.setScore(rs.getInt(4));
        return people;
    }
}
