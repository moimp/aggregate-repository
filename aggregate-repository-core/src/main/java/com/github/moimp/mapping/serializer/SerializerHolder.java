package com.github.moimp.mapping.serializer;

import static com.github.moimp.mapping.serializer.SerializerType.GSON;
import static java.util.Objects.requireNonNull;

public class SerializerHolder {
    public static GsonSerializer getSerializer(SerializerType type) {
        if (GSON.equals(requireNonNull(type))) {
            return new GsonSerializer();
        }
        throw new UnsupportedOperationException("Not Supporting Serializer");
    }

    public static GsonSerializer gsonSerializer() {
        return new GsonSerializer();
    }
}
