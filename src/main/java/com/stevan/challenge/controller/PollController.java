package com.stevan.challenge.controller;

import com.stevan.challenge.dto.PollDto;
import com.stevan.challenge.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Main controller class for managing polls operations.</p>
 * <p>Every operation is done by using {@link PollService} poll service instance and it's methods.</p>
 */
@RestController
@RequestMapping("challenge")
public class PollController {

    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    /**
     * <p>Method which retrieves all polls created by user with the given mail.</p>
     * <p>The call is just forwarded to the service instance which then handles it in a proper way.</p>
     * @param mail User's mail to search for
     * @return List od {@link PollDto} polls created by received user
     */
    @GetMapping("/polls/mail/{mail}")
    public List<PollDto> getPollsForUser(@PathVariable String mail) {
        return pollService.getPollsForUser(mail);
    }

    /**
     * <p>Method which retrieves all polls with the given title.</p>
     * <p>The call is just forwarded to the service instance which then handles it in a proper way.</p>
     * @param title Poll's title to search for
     * @return List od {@link PollDto} polls with the given title
     */
    @GetMapping("/polls/title/{title}")
    public List<PollDto> getPollsByTitle(@PathVariable String title) {
        return pollService.getPollsByTitle(title);
    }

    /**
     * <p>Method which retrieves all polls created after received date.</p>
     * <p>The call is just forwarded to the service instance which then handles it in a proper way.</p>
     * @param date Creation date to search for
     * @return List od {@link PollDto} polls created after received date
     */
    @GetMapping("/polls/date/{date}")
    public List<PollDto> getPollsAfterDate(@PathVariable long date) {
        return pollService.getPollsAfterDate(date);
    }

}
