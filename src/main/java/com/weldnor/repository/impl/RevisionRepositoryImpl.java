package com.weldnor.repository.impl;

import com.weldnor.model.Revision;
import com.weldnor.repository.RevisionRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class RevisionRepositoryImpl implements RevisionRepository {

    private final static String FILENAME = "revisions.txt";

    public RevisionRepositoryImpl() {
    }

    @Override
    public synchronized void save(Revision revision) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true));

            String userId = revision.getUserId();
            Date date = revision.getDate();
            boolean isOnline = revision.isOnline();

            String record = String.format("%s %s %s %n", userId, date.toString(), isOnline ? "online" : "offline");
            writer.write(record);
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
