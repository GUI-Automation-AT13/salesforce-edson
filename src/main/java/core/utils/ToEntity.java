package core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

/**
 * Converts an entity to another.
 */
public class ToEntity {

    /**
     * Converts a map to some entity.
     *
     * @param table is the map that converts.
     * @param cls is the class type to convert to.
     * @param <T> represents any entity.
     * @return any entity.
     * @throws JsonProcessingException .
     */
    public static <T> T convert(Map<String, String> table, Class<T> cls) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(table);
        return new ObjectMapper().readValue(json, cls);
    }

    /**
     * Converts a string to a class.
     *
     * @param className is the string that converts.
     * @param <T> represents any entity.
     * @return a Class entity of type T.
     * @throws ClassNotFoundException in case there is an error.
     */
    public static <T> Class<T> getClassByName(String className) throws ClassNotFoundException {
        return (Class<T>) Class.forName(className);
    }
}
