package com.github.dhslrl321.supports;

public class SerializerHolder {
    public static GsonSerializerUtil getSerializer() {
        return new GsonSerializerUtil();
    }
}
