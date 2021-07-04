package me.weldnor.exception;

public class RevisionNotFoundException extends Exception {
    public RevisionNotFoundException(long revisionId) {
        super("revision with id " + revisionId + " not found");
    }
}
