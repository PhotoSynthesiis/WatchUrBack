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

    public int getFirstWeek(String name) {
        String SQL = "SELECT firstWeek FROM ScoreTrend WHERE name = ?";
        return jdbcTemplate.queryForInt(SQL, new Object[]{name});
    }

    public int getSecondWeek(String name) {
        String SQL = "SELECT secondWeek FROM ScoreTrend WHERE name = ?";
        return jdbcTemplate.queryForInt(SQL, new Object[]{name});
    }

    public int getThirdWeek(String name) {
        String SQL = "SELECT thirdWeek FROM ScoreTrend WHERE name = ?";
        return jdbcTemplate.queryForInt(SQL, new Object[]{name});
    }

    public int getFourthWeek(String name) {
        String SQL = "SELECT fourthWeek FROM ScoreTrend WHERE name = ?";
        return jdbcTemplate.queryForInt(SQL, new Object[]{name});
    }

    public void updateOpposeOfWeek(String name, int week) {
        String SQL;
        int score = 0;
        if (week == 1) {
            score += getFirstWeek(name) + 1;
            SQL = "UPDATE ScoreTrend set firstWeek = ? WHERE name = ?";
        } else if (week == 2) {
            score += getSecondWeek(name) + 1;
            SQL = "UPDATE ScoreTrend set secondWeek = ? WHERE name = ?";
        } else if (week == 3) {
            score += getThirdWeek(name) + 1;
            SQL = "UPDATE ScoreTrend set thirdWeek = ? WHERE name = ?";
        } else {
            score += getFourthWeek(name) + 1;
            SQL = "UPDATE ScoreTrend set fourthWeek = ? WHERE name = ?";
        }
        jdbcTemplate.update(SQL, new Object[]{score, name});
    }

    public void clearDataOf(String name) {
        String SQL = "UPDATE ScoreTrend set firstWeek = 0, secondWeek = 0, thirdWeek = 0, fourthWeek = 0 WHERE name = ?";
        jdbcTemplate.update(SQL, new Object[]{name});
    }
}
