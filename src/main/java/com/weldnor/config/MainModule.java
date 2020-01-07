package com.weldnor.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.weldnor.repository.RevisionRepository;
import com.weldnor.repository.impl.RevisionRepositoryImpl;
import com.weldnor.service.ObserverService;
import com.weldnor.service.VkService;
import com.weldnor.service.impl.ObserverServiceImpl;
import com.weldnor.service.impl.VkServiceImpl;
import com.weldnor.utils.Config;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(VkService.class).to(VkServiceImpl.class).in(Singleton.class);
        bind(ObserverService.class).to(ObserverServiceImpl.class).in(Singleton.class);
        bind(RevisionRepository.class).to(RevisionRepositoryImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    private Config provideConfig() {
        return new Config();
    }
}
