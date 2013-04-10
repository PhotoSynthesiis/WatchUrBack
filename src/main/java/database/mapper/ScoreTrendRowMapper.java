package database.mapper;

import domain.DevScoreTrend;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreTrendRowMapper implements RowMapper<DevScoreTrend> {
    @Override
    public DevScoreTrend mapRow(ResultSet rs, int rowNum) throws SQLException {
        DevScoreTrend trend = new DevScoreTrend();

        String first = rs.getString(1);
        String second = rs.getString(2);
        String third = rs.getString(3);
        String fourth = rs.getString(4);

        trend.setFirst(first);
        trend.setSecond(second);
        trend.setThird(third);
        trend.setFourth(fourth);

        return trend;
    }
}
