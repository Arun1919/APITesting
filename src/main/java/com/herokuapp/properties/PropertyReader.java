package com.herokuapp.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(System.getProperty("env", "staging") + ".properties");
        properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyKey){

        return properties.getProperty(propertyKey);
    }

}
