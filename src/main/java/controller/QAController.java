package controller;

import database.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QAController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping(method = RequestMethod.GET, value = "/voteOrOppose")
    public String decideVoteOrOppose(@RequestParam("param") String param, @RequestParam("name") String name, ModelMap modelMap) {
        if (param.equalsIgnoreCase("vote")) {
            peopleService.voteFor(name);
        } else {
            peopleService.opposeFor(name);
        }

        modelMap.addAttribute("name", name);
        modelMap.addAttribute("score", peopleService.getScoreOf(name));
        return "IndividualResult";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/handleIndividual")
    public String handleIndividual(@RequestParam("name") String name, ModelMap modelMap) {

        modelMap.addAttribute("name", name);
        return "ShowIndividual";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String backToHomePage() {
        return "Welcome";
    }
}
