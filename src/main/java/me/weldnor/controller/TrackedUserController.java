package me.weldnor.controller;

import me.weldnor.dto.TrackedUserDto;
import me.weldnor.exception.TrackedUserNotFoundException;
import me.weldnor.service.TrackedUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trackedUser")
public class TrackedUserController {

    private final TrackedUserService trackedUserService;

    public TrackedUserController(TrackedUserService trackedUserService) {
        this.trackedUserService = trackedUserService;
    }

    @GetMapping
    public List<TrackedUserDto> getAllTrackedUsers() {
        return trackedUserService.getAllTrackedUsers();
    }

    @PostMapping
    public TrackedUserDto addTrackedUser(@RequestBody TrackedUserDto trackedUserDto) {
        return trackedUserService.addTrackedUser(trackedUserDto);
    }

    @DeleteMapping
    public void deleteAllTrackedUsers() {
        trackedUserService.deleteAllTrackedUsers();
    }

    @GetMapping("/{trackedUserId}")
    public TrackedUserDto getTrackedUser(@PathVariable long trackedUserId) throws TrackedUserNotFoundException {
        return trackedUserService.getTrackedUser(trackedUserId);
    }

    @PutMapping("/{trackedUserId}")
    public void updateTrackedUser(@PathVariable long trackedUserId, @RequestBody TrackedUserDto trackedUserDto) throws TrackedUserNotFoundException {
        trackedUserService.updateTrackedUser(trackedUserId, trackedUserDto);
    }

    @DeleteMapping("/{trackedUserId}")
    public void deleteTrackedUser(@PathVariable long trackedUserId) {
        trackedUserService.deleteTrackedUser(trackedUserId);
    }
}
