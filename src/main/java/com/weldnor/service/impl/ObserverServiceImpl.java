package com.weldnor.service.impl;

import com.google.inject.Inject;
import com.weldnor.service.ObserverService;
import com.weldnor.service.VkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ObserverServiceImpl implements ObserverService {

    private static final int INTERVAL = 5;

    private final Logger logger = LoggerFactory.getLogger(ObserverServiceImpl.class);

    private final VkService vkService;

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private List<String> usersId = new CopyOnWriteArrayList<>();


    @Inject
    public ObserverServiceImpl(VkService vkService) {
        this.vkService = vkService;
    }


    @Override
    public void addUser(String user_id) {
        usersId.add(user_id);
    }

    @Override
    public void removeUser(String user_id) {
        usersId.remove(user_id);
    }

    @Override
    public void start() {
        logger.info("start observer service");

        executorService.scheduleWithFixedDelay(() -> {
            for (String user_id : usersId) {
                boolean is_online = vkService.isUserOnline(user_id);
                logger.info("user {} : {}", user_id, is_online ? "online" : "offline");
            }
        }, INTERVAL, INTERVAL, TimeUnit.SECONDS);
    }
}
