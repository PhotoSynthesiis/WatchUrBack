package database.service;

import database.dao.SearchDao;
import domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchService {
    @Autowired
    private SearchDao searchDao;

    public List<People> getPeople(String keyword) {
        return searchDao.get(keyword);
    }

    public List<Object> getInit() {
        return searchDao.get();
    }
}
