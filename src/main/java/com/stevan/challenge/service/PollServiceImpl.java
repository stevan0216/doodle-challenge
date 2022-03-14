package com.stevan.challenge.service;

import com.stevan.challenge.dto.*;
import com.stevan.challenge.entity.*;
import com.stevan.challenge.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>Service implementation class for operations with {@link Poll} polls.</p>
 */

@Service
public class PollServiceImpl implements PollService {

    private final UserRepository userRepository;
    private final PollRepository pollRepository;
    private final PollOptionRepository pollOptionRepository;
    private final PreferenceRepository preferenceRepository;
    private final ParticipantRepository participantRepository;
    private final OptionRepository optionRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public PollServiceImpl(UserRepository userRepository, PollRepository pollRepository, PollOptionRepository pollOptionRepository, PreferenceRepository preferenceRepository, ParticipantRepository participantRepository, OptionRepository optionRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.pollRepository = pollRepository;
        this.pollOptionRepository = pollOptionRepository;
        this.preferenceRepository = preferenceRepository;
        this.participantRepository = participantRepository;
        this.optionRepository = optionRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * <p>Method used for getting polls data from the database which are created by given user.</p>
     * <p>If there is no such user in the database, method returns null.</p>
     * <p>Otherwise, data is being selected from the database and packed in {@link PollDto} objects.</p>
     * @param userMail User to search for
     * @return List of {@link PollDto} objects, encapsulating all important poll data.
     */
    @Override
    public List<PollDto> getPollsForUser(String userMail) {
        if( userMail == null || userMail.equals("") ) return null;
        User user = userRepository.findByMail(userMail);
        if( user == null ) return null;
        UserDto userDto = new UserDto(user);
        List<PollDto> polls = new ArrayList<>();
        List<Poll> userPolls = pollRepository.findByInitiator(user.getIdUser());
        if( userPolls == null ) return null;
        for(Poll poll : userPolls) {
            polls.add(extractPollData(poll, userDto));
        }
        return polls;
    }

    /**
     * <p>Method used for getting polls data from the database which have given title.</p>
     * <p>If there are no such polls in the database, method returns null.</p>
     * <p>Otherwise, data is being selected from the database and packed in {@link PollDto} objects.</p>
     * @param title Poll title to search for
     * @return List of {@link PollDto} objects, encapsulating all important poll data.
     */
    @Override
    public List<PollDto> getPollsByTitle(String title) {
        if( title == null || title.equals("") ) return null;
        List<Poll> pollsWithTitle = pollRepository.findByTitle(title);
        if( pollsWithTitle.size() == 0 ) {
            return null;
        }
        List<PollDto> pollData = new ArrayList<>();
        for(Poll poll : pollsWithTitle) {
            User initiator = userRepository.getById(poll.getInitiator());
            UserDto userDto = new UserDto(initiator);
            pollData.add(extractPollData(poll, userDto));
        }
        return pollData;
    }
    /**
     * <p>Method used for getting polls data from the database which are created after given date.</p>
     * <p>If there are no such polls in the database, method returns null.</p>
     * <p>Otherwise, data is being selected from the database and packed in {@link PollDto} objects.</p>
     * @param dateTimestamp Date limit to search for
     * @return List of {@link PollDto} objects, encapsulating all important poll data.
     */

    @Override
    public List<PollDto> getPollsAfterDate(long dateTimestamp) {
        List<Poll> pollsAfterDate = pollRepository.findPollsAfterDate(dateTimestamp);

        if( pollsAfterDate.size() == 0 ) {
            return null;
        }

        List<PollDto> pollDtos = new ArrayList<>();
        for(Poll poll : pollsAfterDate) {
            User initiator = userRepository.getById(poll.getInitiator());
            UserDto initiatorDto = new UserDto(initiator);
            pollDtos.add(extractPollData(poll, initiatorDto));
        }
        return pollDtos;
    }

    /**
     * <p>Helper method used to retrieve all important data from the database, regarding one {@link Poll} poll.</p>
     * <p>Method's task is to retrieve data about poll options, participants and their preferences.</p>
     * <p>Also, preferences (answers) are grouped together by participant.</p>
     * <p>Retrieved data is packed inside {@link PollDto} object.</p>
     * @param poll {@link Poll} Poll to retrieve data for
     * @param initiatorDto {@link UserDto} Object containing data about poll creator
     * @return {@link PollDto} Object encapsulating all important data.
     */
    private PollDto extractPollData(Poll poll, UserDto initiatorDto) {
        Map<Participant, List<Short>> participantsAndAnswers = new HashMap<>();
        List<OptionDto> options = new ArrayList<>();
        List<PollOption> pollOptions = pollOptionRepository.findByPollId(poll.getIdPoll());
        for(PollOption pollOption : pollOptions) {
            Option option = optionRepository.getOption(pollOption.getOptionId());
            options.add(OptionDtoFactory.getOptionDto(option));
            List<Preference> preferences = preferenceRepository.findByPollOptionId(pollOption.getOptionId());
            for(Preference preference : preferences) {
                Participant participant = participantRepository.getById(preference.getParticipantId());
                List<Short> answers;
                if( participantsAndAnswers.containsKey(participant) ) {
                    answers = participantsAndAnswers.get(participant);
                }
                else {
                    answers = new ArrayList<>();
                }
                answers.add(preference.getAnswer().shortValue());
                participantsAndAnswers.put(participant, answers);
            }
        }
        List<ParticipantDto> participants = new ArrayList<>();
        for(Map.Entry<Participant, List<Short>> entry : participantsAndAnswers.entrySet()) {
            Participant participant = entry.getKey();
            ParticipantDto dto = new ParticipantDto(participant.getIdParticipant(), participant.getName(), entry.getValue());
            participants.add(dto);
        }
        Optional<Location> location = locationRepository.findById(poll.getLocation());
        LocationDto locationDto = null;
        if( location.isPresent() ) locationDto = new LocationDto(location.get());
        return new PollDto.PollDtoBuilder(poll)
                .withInitiator(initiatorDto)
                .withParticipants(participants)
                .withOptions(options)
                .withParticipantsCount(participants.size())
                .withLocation(locationDto)
                .withOptionsHash(String.valueOf(options.hashCode())).build();
    }
}
