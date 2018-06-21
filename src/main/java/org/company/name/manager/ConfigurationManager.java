package org.company.name.manager;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.getDefault());

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {

        return resourceBundle.getString(key);
    }
}
