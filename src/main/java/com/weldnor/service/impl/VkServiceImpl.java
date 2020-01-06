package com.weldnor.service.impl;

import com.google.inject.Inject;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.base.BoolInt;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.weldnor.service.VkService;
import com.weldnor.utils.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VkServiceImpl implements VkService {

    private Logger logger = LoggerFactory.getLogger(VkServiceImpl.class);

    private Config config;

    private VkApiClient vkApiClient;
    private UserActor userActor;

    @Inject
    public VkServiceImpl(Config config) {
        this.config = config;
        init();
    }

    private void init() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        vkApiClient = new VkApiClient(transportClient);

        int USER_ID = Integer.parseInt(config.getOrThrow("user.id"));
        String USER_CODE = config.getOrThrow("user.code");

        userActor = new UserActor(USER_ID, USER_CODE);
    }


    @Override
    public boolean isUserOnline(String user_id) {
        try {
            List<UserXtrCounters> usersInfo = vkApiClient
                    .users()
                    .get(userActor)
                    .fields(Fields.ONLINE)
                    .userIds(user_id)
                    .execute();

            UserXtrCounters userInfo = usersInfo.get(0);
            BoolInt isOnline = userInfo.getOnline();
            return isOnline.ordinal() == 1;

        } catch (ApiException | ClientException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isMeOnline() {
        String MY_USER_ID = config.getOrThrow("user.id");
        return isUserOnline(MY_USER_ID);
    }

}
