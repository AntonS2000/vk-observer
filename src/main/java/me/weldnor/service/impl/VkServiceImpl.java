package me.weldnor.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.weldnor.service.VkService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VkServiceImpl implements VkService {

    @Override
    public boolean isUserOnline(String userId) {
        return false;
    }
}
