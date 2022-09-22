package com.wvoort.wc2022.standingsservice.controller;

import com.wvoort.wc2022.standingsservice.service.StandingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class StandingsWebController {

    @Autowired
    private StandingsService standingsService;

    @GetMapping(value = "/standings/overview")
    public String displayGames(final Model model) {
        log.info("Getting all standings from repository");
        model.addAttribute("standings", standingsService.getStandings() );

        return "standings";

    }

}
