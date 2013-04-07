package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QAController {

    @RequestMapping(method = RequestMethod.POST, value = "/voteOrOppose")
    public String decideVoteOrOppose(@RequestParam("param") String param) {
        if (param.equalsIgnoreCase("vote")) {
            System.out.println("vote");
        } else {
            System.out.println("oppose");
        }

        return "ShowIndividualResult";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/handleIndividual")
    public String handleIndividual(@RequestParam("name") String name, ModelMap modelMap) {

        modelMap.addAttribute("name", name);
        return "ShowIndividualResult";
    }
}
