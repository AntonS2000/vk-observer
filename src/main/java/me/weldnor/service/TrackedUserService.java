package me.weldnor.service;

import lombok.extern.slf4j.Slf4j;
import me.weldnor.dto.TrackedUserDto;
import me.weldnor.entity.TrackedUser;
import me.weldnor.exception.TrackedUserNotFoundException;
import me.weldnor.mapper.TrackedUserMapper;
import me.weldnor.repository.TrackedUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrackedUserService {
    private final me.weldnor.repository.TrackedUserRepository trackedUserRepository;
    private final TrackedUserMapper trackedUserMapper;

    public TrackedUserService(TrackedUserRepository trackedUserRepository, TrackedUserMapper trackedUserMapper) {
        this.trackedUserRepository = trackedUserRepository;
        this.trackedUserMapper = trackedUserMapper;
    }

    public List<TrackedUserDto> getAllTrackedUsers() {
        var trackedUsers = trackedUserRepository.findAll();
        return trackedUserMapper.mapToDto(trackedUsers);
    }

    public void deleteAllTrackedUsers() {
        trackedUserRepository.deleteAll();
    }

    public TrackedUserDto addTrackedUser(TrackedUserDto trackedUserDto) {
        TrackedUser trackedUser = trackedUserMapper.mapToEntity(trackedUserDto);
        trackedUser = trackedUserRepository.save(trackedUser);
        return trackedUserMapper.mapToDto(trackedUser);
    }

    public TrackedUserDto getTrackedUser(long trackedUserId) throws TrackedUserNotFoundException {
        TrackedUser trackedUser = findTrackedUserById(trackedUserId);
        return trackedUserMapper.mapToDto(trackedUser);
    }

    public void updateTrackedUser(long trackedUserId, TrackedUserDto trackedUserDto) throws TrackedUserNotFoundException {
        TrackedUser trackedUser = findTrackedUserById(trackedUserId);
        trackedUserMapper.updateEntity(trackedUser, trackedUserDto);
    }

    public void deleteTrackedUser(long trackedUserId) {
        trackedUserRepository.deleteById(trackedUserId);
    }

    private TrackedUser findTrackedUserById(long trackedUserId) throws TrackedUserNotFoundException {
        return trackedUserRepository.findById(trackedUserId)
                .orElseThrow(() -> new TrackedUserNotFoundException(trackedUserId));
    }
}
