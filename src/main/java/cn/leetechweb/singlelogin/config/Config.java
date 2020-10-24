package cn.leetechweb.singlelogin.config;

import lombok.Data;

import java.io.*;
import java.util.Properties;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 19:14
 *
 * @author junyu lee
 **/
@Data
public class Config {

    private static Config config;

    private final String tokenName;

    private final boolean isHeaderEnabled;

    private final boolean isCookieEnabled;

    private final String authServerUrl;

    private final String appId;

    private Config() throws IOException {
        Properties configProp = new Properties();
        InputStream propIs = Config.class.getClassLoader().getResourceAsStream("config.properties");
        configProp.load(propIs);
        tokenName = configProp.getProperty("token.token-name");
        isHeaderEnabled = Boolean.parseBoolean(configProp.getProperty("token.is-header-enabled"));
        isCookieEnabled = Boolean.parseBoolean(configProp.getProperty("token.is-cookie-enabled"));
        authServerUrl = configProp.getProperty("token.auth-server-url");
        appId = configProp.getProperty("token.app-id");
    }

    public static Config getInstance() {
        if (config == null) {
            synchronized (Config.class) {
                if (config == null) {
                    try {
                        config = new Config();
                    }catch (IOException e) {
                        System.err.println("config初始化错误");
                    }
                }
            }
        }
        return config;
    }

}
