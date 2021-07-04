package me.weldnor.exception;

public class TrackedUserNotFoundException extends Exception {
    public TrackedUserNotFoundException(long trackedUserId) {
        super("tracked user with id " + trackedUserId + " not found");
    }
}
