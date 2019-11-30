package com.qugenx.jsonfiles.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qugenx.jsonfiles.model.UserContextProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

//singleton
public class JsonUtils implements Serializable {

    private static Logger LOG = LoggerFactory
            .getLogger(JsonUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();

    /** private constructor to prevent others from instantiating this class */
    /** Don't let anyone else instantiate this class */
    private JsonUtils(){}

    private static JsonUtils singletonInstance;

    /** Lazily create the instance / initialize the singleton in a synchronized block when it is accessed for the first time */
    public static synchronized JsonUtils getInstance(){
        if(singletonInstance == null){
            singletonInstance = new JsonUtils();
        }
        return singletonInstance;
    }

    public static UserContextProperties loadJsonFile() {

        UserContextProperties userContextProperties = null;

        TypeReference<UserContextProperties> typeReference = new TypeReference<UserContextProperties>(){};
        //TypeReference<List<ArticleDTO>> typeReference = new TypeReference<List<ArticleDTO>>(){};

        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/articles.json");
        try {
            userContextProperties = mapper.readValue(inputStream,typeReference);

            //List<User> users = mapper.readValue(inputStream,typeReference);
            //userService.save(users);
            LOG.info("userContextProperties loaded!");
        } catch (IOException e){
            LOG.info("Unable to load userContextProperties: " + e.getMessage());
        }

        return userContextProperties;
    }

    // implement readResolve method to return the existing instance
    protected Object readResolve() {
        return singletonInstance;
    }


}
