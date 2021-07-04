package me.weldnor.service;

import lombok.extern.slf4j.Slf4j;
import me.weldnor.dto.TrackedUserDto;
import me.weldnor.entity.TrackedUser;
import me.weldnor.exception.TrackedUserNotFoundException;
import me.weldnor.repository.TrackedUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrackedUserService {
    private final me.weldnor.repository.TrackedUserRepository TrackedUserRepository;
    private final me.weldnor.mapper.TrackedUserMapper TrackedUserMapper;

    public TrackedUserService(TrackedUserRepository TrackedUserRepository, me.weldnor.mapper.TrackedUserMapper TrackedUserMapper) {
        this.TrackedUserRepository = TrackedUserRepository;
        this.TrackedUserMapper = TrackedUserMapper;
    }

    public List<TrackedUserDto> getAllTrackedUsers() {
        var trackedUsers = TrackedUserRepository.findAll();
        return TrackedUserMapper.mapToDto(trackedUsers);
    }

    public void deleteAllTrackedUsers() {
        TrackedUserRepository.deleteAll();
    }

    public TrackedUserDto addTrackedUser(TrackedUserDto trackedUserDto) {
        TrackedUser TrackedUser = TrackedUserMapper.mapToEntity(trackedUserDto);
        TrackedUser = TrackedUserRepository.save(TrackedUser);
        return TrackedUserMapper.mapToDto(TrackedUser);
    }

    public TrackedUserDto getTrackedUser(long trackedUserId) throws TrackedUserNotFoundException {
        TrackedUser TrackedUser = findTrackedUserById(trackedUserId);
        return TrackedUserMapper.mapToDto(TrackedUser);
    }

    public void updateTrackedUser(long trackedUserId, TrackedUserDto trackedUserDto) throws TrackedUserNotFoundException {
        TrackedUser TrackedUser = findTrackedUserById(trackedUserId);
        TrackedUserMapper.updateEntity(TrackedUser, trackedUserDto);
    }

    public void deleteTrackedUser(long trackedUserId) {
        TrackedUserRepository.deleteById(trackedUserId);
    }

    private TrackedUser findTrackedUserById(long trackedUserId) throws TrackedUserNotFoundException {
        return TrackedUserRepository.findById(trackedUserId)
                .orElseThrow(() -> new TrackedUserNotFoundException(trackedUserId));
    }
}
