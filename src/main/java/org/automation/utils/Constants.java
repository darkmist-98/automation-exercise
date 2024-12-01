package org.automation.utils;

import java.io.File;

public class Constants {
    private static final String separator = File.separator;

    private static final String ENVIRONMENT_PROPERTIES_FILE = System.getProperty("user.dir")+separator+
            "src"+separator+"test"+separator+"resources";

    public static String getEnvironmentPropertiesFile() {
        return ENVIRONMENT_PROPERTIES_FILE + separator + "environment.properties";
    }
    public static String getLog4jPropertyFile() {
        return System.getProperty("user.dir")+separator+"src"+separator+"main"+separator+"resources"+
                separator+"log4j.properties";
    }
}
