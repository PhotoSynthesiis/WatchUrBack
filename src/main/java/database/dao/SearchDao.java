package database.dao;

import database.mapper.PeopleRowMapper;
import domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchDao")
public class SearchDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<People> get(String keyword) {
        String SQL = "SELECT * FROM PersonInfo WHERE name LIKE ?";
        return jdbcTemplate.query(SQL, new String[]{"%" + keyword + "%"}, new BeanPropertyRowMapper<People>(People.class));
    }

    public List<Object> get() {
        String SQL = "SELECT * FROM PersonInfo";
        return jdbcTemplate.query(SQL, new PeopleRowMapper());
    }
}
