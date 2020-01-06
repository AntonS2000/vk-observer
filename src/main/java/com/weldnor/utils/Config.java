package com.weldnor.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Config {

    private static final String path = "/application.properties";

    private Properties properties = new Properties();

    public Config() {
        loadProperties();
    }

    private void loadProperties() {
        InputStream is = this.getClass().getResourceAsStream(path);
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("cant load config file");
        }
    }

    public Optional<String> get(String name) {
        String value = properties.getProperty(name);
        return Optional.of(value);
    }

    public String getOrDefault(String name, String defaultValue) {
        return get(name).orElse(defaultValue);
    }

    public String getOrThrow(String name) {
        return get(name).orElseThrow();
    }

}
