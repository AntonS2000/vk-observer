package com.weldnor.service;

public interface ObserverService {
    void addUser(String user_id);

    void removeUser(String user_id);

    void start();
}
