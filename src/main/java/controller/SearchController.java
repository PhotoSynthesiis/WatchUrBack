package controller;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import database.service.SearchService;
import domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nullable;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    @Qualifier("searchService")
    private SearchService searchService;

    @RequestMapping(value = "/searchPeople", method = RequestMethod.GET)
    public
    @ResponseBody
    String handleSearch(@RequestParam("keyword") String keyword) {
        List<People> peopleList = searchService.getPeople(keyword);

        List<String> names = Lists.transform(peopleList, new Function<People, String>() {
            @Override
            public String apply(@Nullable People from) {
                return from.getName();
            }
        });

        return Joiner.on(",").skipNulls().join(names);
    }
}
