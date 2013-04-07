package database.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("peopleDao")
public class PeopleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void update(String name, int score) {
        String SQL = "update PersonInfo set score = ? where name = ?";
        jdbcTemplate.update(SQL, new Object[]{score, name});
    }

    public int getScore(String name) {
        String SQL = "select score from PersonInfo where name = ?";
        return jdbcTemplate.queryForInt(SQL, name);
    }
}
