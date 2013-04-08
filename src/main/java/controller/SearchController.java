package controller;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import database.service.SearchService;
import domain.ComparatorPeople;
import domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Controller
public class SearchController {

    @Autowired
    @Qualifier("searchService")
    private SearchService searchService;

    @RequestMapping(value = "/searchPeople", method = RequestMethod.GET)
    public
    @ResponseBody
    String handleSearch(@RequestParam("keyword") String keyword) {
        if (!hasText(keyword)) {
            return "";
        }

        List<People> peopleList = searchService.getPeople(keyword);


        List<String> names = Lists.transform(peopleList, new Function<People, String>() {
            @Override
            public String apply(@Nullable People from) {
                return from.getName();
            }
        });

        return Joiner.on(",").skipNulls().join(names);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String forHomePage(ModelMap modelMap, HttpServletRequest request) {

        List<Object> devList = searchService.getDev();
        List<Object> qaList = searchService.getQA();

        ComparatorPeople comparatorPeople = new ComparatorPeople();
        Collections.sort(devList, comparatorPeople);
        Collections.sort(qaList, comparatorPeople);

        modelMap.addAttribute("devList", devList);
        modelMap.addAttribute("qaList", qaList);
        modelMap.addAttribute("username", request.getRemoteUser());

        return "Welcome";
    }
}
