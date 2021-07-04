package me.weldnor.service;

import lombok.extern.slf4j.Slf4j;
import me.weldnor.dto.RevisionDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrackingService {

    private final TrackedUserService trackedUserService;
    private final RevisionService revisionService;
    private final VkService vkService;

    public TrackingService(TrackedUserService trackedUserService, RevisionService revisionService, VkService vkService) {
        this.trackedUserService = trackedUserService;
        this.revisionService = revisionService;
        this.vkService = vkService;
    }

    @Scheduled(fixedDelay = 20000)
    public void update() {
        var userDtoList = trackedUserService.getAllTrackedUsers();

        userDtoList.forEach(userDto -> {
            var isOnline = vkService.isUserOnline(userDto.getUsername());
            var revisionDto = new RevisionDto(null, userDto.getUsername(), isOnline, null);
            revisionService.addRevision(revisionDto);
            log.info("user: {}, status: {}", userDto.getUsername(), isOnline);
        });
    }

}
