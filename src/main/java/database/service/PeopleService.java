package database.service;

import database.dao.PeopleDao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("peopleService")
public class PeopleService {
    @Autowired
    private PeopleDao peopleDao;
    private DateTime dateTime = new DateTime();
    private boolean shouldNewMonthBegin = false;

    public void updateTotalScore(String name, int score) {
        peopleDao.updateTotalScore(name, score);
    }

    public void voteFor(String name) {
        updateTotalScore(name, getTotalScoreOf(name) + 1);
        updateVoteScore(name, getVoteScoreOf(name) + 1);
    }

    private void updateOpposeOf(String name, int week) {
        peopleDao.updateOpposeOfWeek(name, week);
    }

    private void updateVoteScore(String name, int score) {
        peopleDao.updateVoteScore(name, score);
    }

    public int getVoteScoreOf(String name) {
        return peopleDao.getVoteScoreOf(name);
    }

    public void opposeFor(String name) {
        updateTotalScore(name, getTotalScoreOf(name) + 1);
        UpdateOpposeScore(name, getOpposeScoreOf(name) + 1);
        int factor = dateTime.getDayOfMonth() / 7;
        if (factor <= 1) {
            if (shouldNewMonthBegin) {
                clearDataOfLastMonth(name);
            }
            updateOpposeOf(name, 1);
        } else if (factor <= 2) {
            updateOpposeOf(name, 2);
        } else if (factor <= 3) {
            updateOpposeOf(name, 3);
        } else {
            updateOpposeOf(name, 4);
        }
    }

    private void clearDataOfLastMonth(String name) {
        peopleDao.clearDataOf(name);
    }

    private void UpdateOpposeScore(String name, int score) {
        peopleDao.updateOpposeScoreOf(name, score);
    }

    public int getOpposeScoreOf(String name) {
        return peopleDao.getOpposeScoreOf(name);
    }

    public int getTotalScoreOf(String name) {
        return peopleDao.getScore(name);
    }

    public String getEmailOf(String name) {
        return peopleDao.getEmailOf(name);
    }

    public String getNameOf(String qaName) {
        return peopleDao.getNameOf(qaName);
    }

}
