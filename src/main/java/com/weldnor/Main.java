package com.weldnor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.weldnor.config.MainModule;
import com.weldnor.service.VkService;
import com.weldnor.utils.Config;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new MainModule());

        VkService service = injector.getInstance(VkService.class);
        Config config = injector.getInstance(Config.class);


        System.out.println(service.isMeOnline());

        String MY_USER_ID = config.getOrThrow("user.id");
        System.out.println(service.isUserOnline(MY_USER_ID));
    }
}
