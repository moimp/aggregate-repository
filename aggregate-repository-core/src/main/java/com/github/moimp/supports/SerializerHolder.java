package com.github.moimp.supports;

import java.util.Objects;

import static com.github.moimp.supports.SerializerType.GSON;
import static java.util.Objects.requireNonNull;

public class SerializerHolder {
    public static GsonSerializer getSerializer(SerializerType type) {
        if (GSON.equals(requireNonNull(type))) {
            return new GsonSerializer();
        }
        throw new UnsupportedOperationException("Not Supporting Json Serializer now");
    }
}
