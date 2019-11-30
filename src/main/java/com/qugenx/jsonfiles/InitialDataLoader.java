package com.qugenx.jsonfiles;


import com.qugenx.jsonfiles.model.UserContextProperties;
import com.qugenx.jsonfiles.utils.JsonUtils;
import com.qugenx.jsonfiles.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private Logger LOGGER = LoggerFactory
            .getLogger(this.getClass());

    private JsonUtils jsonUtils;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        jsonUtils = JsonUtils.getInstance();
        UserContextProperties userContextProperties = jsonUtils.getUserContextProperties();
        LOGGER.info("----- Before Run Application -- START LOAD DATA -----");
        LOGGER.info("InitialDataLoader: onApplicationEvent --> userContext = {}", MyUtils.convertObjectToString(userContextProperties));
        LOGGER.info("----- Before Run Application -- FINISH LOAD DATA -----");

    }

}

