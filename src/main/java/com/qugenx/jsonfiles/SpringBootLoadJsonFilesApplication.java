package com.qugenx.jsonfiles;

import com.qugenx.jsonfiles.model.UserContextProperties;
import com.qugenx.jsonfiles.utils.JsonUtils;
import com.qugenx.jsonfiles.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoadJsonFilesApplication implements CommandLineRunner {


    private static Logger LOGGER = LoggerFactory
            .getLogger(SpringBootLoadJsonFilesApplication.class);


    private JsonUtils jsonUtils;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoadJsonFilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("----- START Run Application -- START RETREIVE DATA -----");
        jsonUtils = JsonUtils.getInstance();
        UserContextProperties userContextProperties = jsonUtils.getUserContextProperties();
        LOGGER.info("EXECUTING : command line runner with userContext = {}", MyUtils.convertObjectToString(userContextProperties));
        LOGGER.info("----- START Run Application -- FINISH RETREIVE DATA -----");
    }
}
