package com.github.moimp.supports;

public class SerializerHolder {
    public static GsonSerializerUtil getSerializer() {
        return new GsonSerializerUtil();
    }
}
