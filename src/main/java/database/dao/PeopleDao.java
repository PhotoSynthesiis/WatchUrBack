package database.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("peopleDao")
public class PeopleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateTotalScore(String name, int score) {
        String SQL = "update PersonInfo set totalScore = ? where name = ?";
        jdbcTemplate.update(SQL, new Object[]{score, name});
    }

    public int getScore(String name) {
        String SQL = "select totalScore from PersonInfo where name = ?";
        return jdbcTemplate.queryForInt(SQL, name);
    }

    public String getEmailOf(String name) {
        String SQL = "select email from PersonInfo where name = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{name}, String.class);
    }

    public String getNameOf(String keyword) {
        String SQL = "SELECT name FROM PersonInfo WHERE email LIKE ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{"%" + keyword + "%"}, String.class);
    }

    public int getVoteScoreOf(String name) {
        String SQL = "select voteScore from PersonInfo where name = ?";
        return jdbcTemplate.queryForInt(SQL, name);
    }

    public void updateVoteScore(String name, int score) {
        String SQL = "update PersonInfo set voteScore = ? where name = ?";
        jdbcTemplate.update(SQL, new Object[]{score, name});
    }

    public int getOpposeScoreOf(String name) {
        String SQL = "select opposeScore from PersonInfo where name = ?";
        return jdbcTemplate.queryForInt(SQL, name);
    }

    public void updateOpposeScoreOf(String name, int score) {
        String SQL = "update PersonInfo set opposeScore = ? where name = ?";
        jdbcTemplate.update(SQL, new Object[]{score, name});
    }
}
