package com.github.moimp.supports;

import com.github.moimp.fixture.*;
import com.github.moimp.mapping.serializer.GsonSerializer;
import com.github.moimp.mapping.serializer.Serializer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GsonSerializerTestUtil {

    Serializer sut = new GsonSerializer();

    @Test
    void can_serialize() {
        String actual = sut.serialize(fooOf(1, "kim", 20));

        assertThat(actual).isEqualTo(fooJsonOf(1, "kim", 20));
    }

    @Test
    void can_deserialize() {
        Foo actual = sut.deserialize(fooJsonOf(1, "jang", 10), Foo.class);

        assertThat(actual).isEqualTo(fooOf(1, "jang", 10));
    }

    private Foo fooOf(long id, String name, int age) {
        return FooFixtures.newFoo(id, name, age);
    }

    private String fooJsonOf(long id, String name, int age) {
        return String.format("{\"id\":{\"value\":%d},\"information\":{\"name\":{\"value\":\"%s\"},\"age\":{\"value\":%d}},\"version\":0}",
                id, name, age);
    }
}

