package com.github.moimp.supports;

public interface SerializerUtil {

    String serialize(Object object);

    <T> T deserialize(String json, Class<T> clazz);
}
