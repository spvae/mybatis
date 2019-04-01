package com.mybatis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import util.ClassUtils;

public class Messages {
    private static Log log = LogFactory.getLog(message.Messages.class);
    public static final String APPLICATION_RESOURCES = "mybatis/jdbc.properties";
    private static Messages msg;
    private static Map<String, Properties> map;
    private static String appName;

    public String getAppName() {
        return appName;
    }

    private Messages() {
        map = new HashMap();
    }

    public static Messages getInstance() {
        if(msg == null) {
            msg = new Messages();
        }

        return msg;
    }

    public Properties getProperties() {
        return this.getProperties((String)null);
    }

    public Properties getProperties(String resourceName) {
        if(resourceName == null) {
            resourceName = APPLICATION_RESOURCES;
        }

        Properties prop = null;
        if(map.containsKey(resourceName)) {
            prop = (Properties)map.get(resourceName);
        } else {
            prop = loadProperties(resourceName);
            map.put(resourceName, prop);
        }

        return prop;
    }

    public Properties getProperties(Class<?> clasz) {
        if(clasz == null) {
            return null;
        } else {
            String name = clasz.getName();
            name = name.replace('.', '/');
            name = name.concat(".properties");
            return this.getProperties(name);
        }
    }

    public Properties getProperties(Class<?> clasz, String resourceName) {
        if(clasz != null) {
            String name = clasz.getName();
            name = name.substring(0, name.lastIndexOf("."));
            name = name.replace('.', '/');
            resourceName = name.concat("/" + resourceName);
        }

        return this.getProperties(resourceName);
    }

    public String getProperty(String resourceName, String key) {
        Properties prop = this.getProperties(resourceName);
        return prop.getProperty(key);
    }

    public String getProperty(String key) {
        return this.getProperty((String)null, key);
    }

    public static Properties loadProperties(String resourceName) {
        Properties properties = new Properties();
        InputStream is = null;

        try {
            Enumeration e = ClassUtils.getDefaultClassLoader().getResources(resourceName);

            while(e.hasMoreElements()) {
                URL url = (URL)e.nextElement();
                URLConnection con = url.openConnection();
                con.setUseCaches(false);
                is = con.getInputStream();
                properties.load(is);
            }
        } catch (IOException var14) {
            log.error(var14);
            var14.printStackTrace();
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException var13) {
                    log.error(var13);
                    var13.printStackTrace();
                }
            }

        }

        return properties;
    }

    public static Properties loadProperties(File file) {
        Properties properties = new Properties();
        FileInputStream is = null;

        try {
            is = new FileInputStream(file);
            properties.load(is);
        } catch (IOException var12) {
            log.error(var12);
            var12.printStackTrace();
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException var11) {
                    log.error(var11);
                    var11.printStackTrace();
                }
            }

        }

        return properties;
    }

    public void removeProperties(String resourceName) {
        if(resourceName != null) {
            map.remove(resourceName);
        }
    }

    public static ResourceBundle getBundle(Locale locale) {
        return getBundle("LocalStrings", locale);
    }

    public static ResourceBundle getBundle(String resourceName, Locale locale) {
        return ResourceBundle.getBundle(resourceName, locale);
    }

    public static ResourceBundle getBundle(Class<?> clasz, Locale locale) {
        String name = clasz.getName();
        name = name.replace('.', '/');
        return ResourceBundle.getBundle(name, locale);
    }

    public static String getString(String keyName, Locale locale) {
        return getBundle(locale).getString(keyName);
    }

    public void setAppName(String appName) {
        appName = appName;
    }

    public void destroy() {
        map.clear();
    }
}
