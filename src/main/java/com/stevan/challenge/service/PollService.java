package com.stevan.challenge.service;

import com.stevan.challenge.dto.PollDto;

import java.util.List;

public interface PollService {

    List<PollDto> getPollsForUser(String userMail);

    List<PollDto> getPollsByTitle(String title);

    List<PollDto> getPollsAfterDate(long dateTimestamp);

}
