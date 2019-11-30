package com.qugenx.jsonfiles.environment;

import com.qugenx.jsonfiles.model.UserContextProperties;
import com.qugenx.jsonfiles.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonUtilsTest {

    private UserContextProperties userContextProperties;
    private JsonUtils jsonUtils = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        jsonUtils = JsonUtils.getInstance();
        assertThat(jsonUtils).isNotNull();
    }

    @Test
    public void testLoadUserContext(){
        userContextProperties = jsonUtils.loadJsonFile();
        assertThat(userContextProperties).isNotNull();
    }
}
