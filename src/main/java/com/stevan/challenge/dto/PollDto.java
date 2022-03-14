package com.stevan.challenge.dto;

import com.stevan.challenge.entity.Poll;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DTO class which encapsulates all important data about the polls </p>
 * <p>including extracted details about initiator, options, participants and location.</p>
 */

public class PollDto implements Serializable {

    private String id;
    private String adminKey;
    private long latestChange;
    private long initiated;
    private int participantsCount;
    private int invitesCount;
    private String type;
    private Boolean hidden;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;
    private String description;
    private UserDto initiator;
    private List<OptionDto> options;
    private String optionsHash;
    private List<ParticipantDto> participants;
    private String device;
    private String levels;
    private LocationDto location;
    private final List<String> invitees = new ArrayList<>();

    private PollDto(PollDtoBuilder builder) {
        this.id = builder.idPoll;
        this.adminKey = builder.adminKey;
        this.latestChange = builder.latestChange;
        this.initiated = builder.initiated;
        this.participantsCount = builder.participantsCount;
        this.invitesCount = builder.invitesCount;
        this.type = builder.type.getType();
        this.hidden = shortToBool(builder.hidden.shortValue());
        this.preferencesType = builder.preferencesType.getType();
        this.state = builder.state.getType();
        this.locale = builder.locale;
        this.title = builder.title;
        this.description = builder.description;
        this.initiator = builder.initiator;
        this.options = builder.options;
        this.optionsHash = builder.optionsHash;
        this.participants = builder.participants;
        this.device = builder.device.getType();
        this.levels = builder.levels.getType();
        this.location = builder.location;
    }

    private Boolean shortToBool(Short value) {
        return value != 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public long getLatestChange() {
        return latestChange;
    }

    public void setLatestChange(long latestChange) {
        this.latestChange = latestChange;
    }

    public long getInitiated() {
        return initiated;
    }

    public void setInitiated(long initiated) {
        this.initiated = initiated;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public int getInvitesCount() {
        return invitesCount;
    }

    public void setInvitesCount(int invitesCount) {
        this.invitesCount = invitesCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getPreferencesType() {
        return preferencesType;
    }

    public void setPreferencesType(String preferencesType) {
        this.preferencesType = preferencesType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserDto getInitiator() {
        return initiator;
    }

    public void setInitiator(UserDto initiator) {
        this.initiator = initiator;
    }

    public List<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }

    public String getOptionsHash() {
        return optionsHash;
    }

    public void setOptionsHash(String optionsHash) {
        this.optionsHash = optionsHash;
    }

    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDto> participants) {
        this.participants = participants;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public static class PollDtoBuilder {
        private String idPoll;
        private String adminKey;
        private long latestChange;
        private long initiated;
        private int participantsCount;
        private int invitesCount;
        private Poll.Type type;
        private Byte hidden;
        private Poll.PreferencesType preferencesType;
        private Poll.State state;
        private String locale;
        private String title;
        private String description;
        private UserDto initiator;
        private List<OptionDto> options;
        private String optionsHash;
        private List<ParticipantDto> participants;
        private Poll.Device device;
        private Poll.Levels levels;
        private LocationDto location;

        public PollDtoBuilder(Poll poll) {
            BeanUtils.copyProperties(poll, this);
        }

        public PollDtoBuilder withParticipantsCount(int participantsCount) {
            this.participantsCount = participantsCount;
            return this;
        }

        public PollDtoBuilder withInvitesCount(int invitesCount) {
            this.invitesCount = invitesCount;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public PollDtoBuilder withInitiator(UserDto initiator) {
            this.initiator = initiator;
            return this;
        }

        public PollDtoBuilder withOptions(List<OptionDto> options) {
            this.options = options;
            return this;
        }

        public PollDtoBuilder withParticipants(List<ParticipantDto> participants) {
            this.participants = participants;
            return this;
        }

        public PollDtoBuilder withOptionsHash(String optionsHash) {
            this.optionsHash = optionsHash;
            return this;
        }

        public PollDtoBuilder withLocation(LocationDto location) {
            this.location = location;
            return this;
        }

        public PollDto build() {
            return new PollDto(this);
        }

        public String getIdPoll() {
            return idPoll;
        }

        public void setIdPoll(String idPoll) {
            this.idPoll = idPoll;
        }

        public String getAdminKey() {
            return adminKey;
        }

        public void setAdminKey(String adminKey) {
            this.adminKey = adminKey;
        }

        public long getLatestChange() {
            return latestChange;
        }

        public void setLatestChange(long latestChange) {
            this.latestChange = latestChange;
        }

        public long getInitiated() {
            return initiated;
        }

        public void setInitiated(long initiated) {
            this.initiated = initiated;
        }

        public int getParticipantsCount() {
            return participantsCount;
        }

        public void setParticipantsCount(int participantsCount) {
            this.participantsCount = participantsCount;
        }

        public int getInvitesCount() {
            return invitesCount;
        }

        public void setInvitesCount(int invitesCount) {
            this.invitesCount = invitesCount;
        }

        public Poll.Type getType() {
            return type;
        }

        public void setType(Poll.Type type) {
            this.type = type;
        }

        public Byte getHidden() {
            return hidden;
        }

        public void setHidden(Byte hidden) {
            this.hidden = hidden;
        }

        public Poll.PreferencesType getPreferencesType() {
            return preferencesType;
        }

        public void setPreferencesType(Poll.PreferencesType preferencesType) {
            this.preferencesType = preferencesType;
        }

        public Poll.State getState() {
            return state;
        }

        public void setState(Poll.State state) {
            this.state = state;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public UserDto getInitiator() {
            return initiator;
        }

        public void setInitiator(UserDto initiator) {
            this.initiator = initiator;
        }

        public List<OptionDto> getOptions() {
            return options;
        }

        public void setOptions(List<OptionDto> options) {
            this.options = options;
        }

        public String getOptionsHash() {
            return optionsHash;
        }

        public void setOptionsHash(String optionsHash) {
            this.optionsHash = optionsHash;
        }

        public List<ParticipantDto> getParticipants() {
            return participants;
        }

        public void setParticipants(List<ParticipantDto> participants) {
            this.participants = participants;
        }

        public Poll.Device getDevice() {
            return device;
        }

        public void setDevice(Poll.Device device) {
            this.device = device;
        }

        public Poll.Levels getLevels() {
            return levels;
        }

        public void setLevels(Poll.Levels levels) {
            this.levels = levels;
        }

        public LocationDto getLocation() {
            return location;
        }

        public void setLocation(LocationDto location) {
            this.location = location;
        }
    }

}
