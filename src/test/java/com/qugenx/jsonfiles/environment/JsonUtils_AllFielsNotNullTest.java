package com.qugenx.jsonfiles.environment;

import com.qugenx.jsonfiles.model.UserContextProperties;
import com.qugenx.jsonfiles.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonUtils_AllFielsNotNullTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private UserContextProperties userContextProperties;
    private JsonUtils jsonUtils = null;

    private Set<Class> getClassNative(){
        Set<Class> classSet = new HashSet<>();
        classSet.add(String.class);
        classSet.add(Integer.class);
        classSet.add(Double.class);
        classSet.add(BigDecimal.class);
        classSet.add(ArrayList.class);
        classSet.add(Long.class);
        return classSet;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        jsonUtils = JsonUtils.getInstance();
        assertThat(jsonUtils).isNotNull();
    }

    @Test
    public void shouldGetJsonContent_andTestAllFieldsNotNull() {
        // Given
        UserContextProperties userContextProperties = jsonUtils.getUserContextProperties();

        // When
        // Then
        assertAllFieldsNotNull(UserContextProperties.class, userContextProperties);
    }

    private void assertAllFieldsNotNull(Class tClass, Object object) {
        Field[] fields = tClass.getDeclaredFields();
        Field[] parentFields = tClass.getSuperclass().getDeclaredFields();

        List<Field> allFields = new ArrayList<>();
        allFields.addAll(Arrays.asList(fields));
        allFields.addAll(Arrays.asList(parentFields));

        assertThat(allFields).isNotEmpty();
        for (Field field : allFields) {
            field.setAccessible(true);
            Object member = null;

            try {
                try {
                    member = field.get(object);
                    assertThat(member).isNotNull();
                    if(! getClassNative().contains(member.getClass())) {
                        assertAllFieldsNotNull(member.getClass(), member);
                    }

                } catch (IllegalAccessException e) {
                    LOGGER.error("Error while testing class", e);
                }
            } catch (AssertionError e) {
                LOGGER.error("Parent " + tClass.getSimpleName() +  " : " + field.getName());
                throw e;
            } catch (NullPointerException e){
                //log.error("Parent " + tClass.getSimpleName() +  " : " + field.getName() + " " + e);
                throw new AssertionError("Parent " + tClass.getSimpleName() +  " : " + field.getName());
            }
        }

    }


}
