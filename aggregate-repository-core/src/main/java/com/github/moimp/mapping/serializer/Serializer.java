package com.github.moimp.mapping.serializer;

public interface Serializer {

    String serialize(Object object);

    <T> T deserialize(String json, Class<T> clazz);
}
