package com.stevan.challenge.controller;

import com.stevan.challenge.dto.PollDto;
import com.stevan.challenge.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("challenge")
public class PollController {

    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/polls/mail/{mail}")
    public List<PollDto> getPollsForUser(@PathVariable String mail) {
        return pollService.getPollsForUser(mail);
    }

    @GetMapping("/polls/title/{title}")
    public List<PollDto> getPollsByTitle(@PathVariable String title) {
        return pollService.getPollsByTitle(title);
    }

    @GetMapping("/polls/date/{date}")
    public List<PollDto> getPollsAfterDate(@PathVariable long date) {
        return pollService.getPollsAfterDate(date);
    }

}
