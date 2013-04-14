package database.dao;

import database.mapper.PeopleRowMapper;
import database.mapper.ScoreTrendRowMapper;
import domain.DevScoreTrend;
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

    public List<Object> getDev() {
        String SQL = "SELECT * FROM PersonInfo WHERE role = 'dev'";
        return jdbcTemplate.query(SQL, new PeopleRowMapper());
    }

    public List<Object> getQA() {
        String SQL = "SELECT * FROM PersonInfo WHERE role = 'qa'";
        return jdbcTemplate.query(SQL, new PeopleRowMapper());
    }

    public DevScoreTrend getScoreOfWeeks(String name) {
        String SQL = "SELECT firstWeek, secondWeek, thirdWeek, fourthWeek FROM ScoreTrend WHERE name = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{name}, new ScoreTrendRowMapper());
    }
}
