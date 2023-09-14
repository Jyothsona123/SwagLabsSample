package com.swag.ui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {


    public static String geValue( String key){
        InputStream path = PropertyReader.class
                .getClassLoader().getResourceAsStream("env.properties");
        Properties prop = new Properties();
        try {
            prop.load(path);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
