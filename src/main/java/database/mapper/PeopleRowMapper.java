package database.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleRowMapper implements RowMapper<Object> {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        PeopleResultSetExtractor extractor = new PeopleResultSetExtractor();
        return extractor.extractData(rs);
    }
}
