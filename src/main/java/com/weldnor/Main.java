package com.weldnor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.weldnor.config.MainModule;
import com.weldnor.service.ObserverService;
import com.weldnor.utils.Config;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new MainModule());

        ObserverService observerService = injector.getInstance(ObserverService.class);
        Config config = injector.getInstance(Config.class);


        String MY_USER_ID = config.getOrThrow("user.id");

        observerService.addUser(MY_USER_ID);

        observerService.start();
    }
}
