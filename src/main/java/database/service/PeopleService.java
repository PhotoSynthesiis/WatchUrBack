package database.service;

import database.dao.PeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("peopleService")
public class PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    public void updateTotalScore(String name, int score) {
        peopleDao.updateTotalScore(name, score);
    }

    public void voteFor(String name) {
        updateTotalScore(name, getTotalScoreOf(name) + 1);
        updateVoteScore(name, getVoteScoreOf(name) + 1);
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
