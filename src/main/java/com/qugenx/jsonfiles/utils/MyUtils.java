package com.qugenx.jsonfiles.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MyUtils {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static ObjectMapper mapper = new ObjectMapper();

    public static String convertObjectToString(Object obj) {
        String jsonInString = "";

        try {
            //Object to JSON in file
            //mapper.writeValue(new File("c:\\user.json"), user);

            //Object to JSON in String
            jsonInString = mapper.writeValueAsString(obj);
            LOG.error("convertObjectToString: jsonInString = {}", jsonInString);

        } catch (JsonProcessingException e) {
            LOG.error("convertObjectToString: Error with message = {}",e.getMessage());
        }

        return jsonInString;
    }
}
