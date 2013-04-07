package database.service;

import database.dao.PeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("peopleService")
public class PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    public void updateScore(String name, int score) {
        peopleDao.update(name, score);
    }

    public void voteFor(String name) {
        int score = getScoreOf(name);
        updateScore(name, score + 1);
    }

    public void opposeFor(String name) {
        int score = getScoreOf(name);
        updateScore(name, score - 1);
    }

    public int getScoreOf(String name) {
        return peopleDao.getScore(name);
    }
}
