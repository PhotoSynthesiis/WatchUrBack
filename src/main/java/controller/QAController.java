package controller;

import database.service.PeopleService;
import database.service.SearchService;
import domain.ComparatorPeople;
import domain.DevScoreTrend;
import domain.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class QAController {
    @Autowired
    private PeopleService peopleService;

    @Autowired
    @Qualifier("searchService")
    private SearchService searchService;

    @Autowired
    private MailSender mailSender;

    @RequestMapping(method = RequestMethod.GET, value = "/voteOrOppose")
    public String decideVoteOrOppose(@RequestParam("param") String param, @RequestParam("name") String name,
                                     ModelMap modelMap, HttpServletRequest request) {
        if (param.equalsIgnoreCase("vote")) {
            peopleService.voteFor(name);
//            mailSender.sendEmailTo(peopleService.getEmailOf(name));
        } else {
            peopleService.opposeFor(name);
        }

        peopleService.voteFor(peopleService.getNameOf(request.getRemoteUser()));

        modelMap.addAttribute("name", name);
        modelMap.addAttribute("score", peopleService.getTotalScoreOf(name));

        DevScoreTrend scoreTrend = searchService.getScoresOf(name);

        String first = scoreTrend.getFirst();
        String second = scoreTrend.getSecond();
        String third = scoreTrend.getThird();
        String fourth = scoreTrend.getFourth();

        modelMap.addAttribute("first", first);
        modelMap.addAttribute("second", second);
        modelMap.addAttribute("third", third);
        modelMap.addAttribute("fourth", fourth);
        return "IndividualResult";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/handleIndividual")
    public String handleIndividual(@RequestParam("name") String name, ModelMap modelMap) {

        modelMap.addAttribute("name", name);
        return "ShowIndividual";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/home"})
    public String backToHomePage(ModelMap modelMap) {
        List<Object> devList = searchService.getDev();
        List<Object> qaList = searchService.getQA();

        ComparatorPeople comparatorPeople = new ComparatorPeople();
        Collections.sort(devList, comparatorPeople);
        Collections.sort(qaList, comparatorPeople);

        modelMap.addAttribute("devList", devList);
        modelMap.addAttribute("qaList", qaList);

        return "Welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/chart")
    public String showChart() {
        return "chart2";
    }
}
