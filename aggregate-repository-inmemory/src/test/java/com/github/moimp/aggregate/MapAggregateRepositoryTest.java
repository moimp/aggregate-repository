package com.github.moimp.aggregate;

import com.github.moimp.aggregate.fixture.*;
import com.github.moimp.mapping.serializer.SerializerHolder;
import com.github.moimp.mapping.serializer.SerializerType;
import com.github.moimp.mapping.instantiator.Instantiator;
import com.github.moimp.general.GeneralAggregateRepository;
import com.github.moimp.record.AggregateRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MapAggregateRepositoryTest {

    GeneralAggregateRepository<FooId, Foo> sut;

    Instantiator<FooId, Foo> fooInstantiator = MapAggregateRepositoryTest::instantiate;

    private static Foo instantiate(AggregateRecord<FooId> record) {
        return SerializerHolder.gsonSerializer().deserialize(record.getSerialized(), Foo.class);
    }

    @BeforeEach
    void setUp() {
        sut = new GeneralAggregateRepository<>(new MapAggregateRepository<>(), fooInstantiator);
    }

    @Test
    @DisplayName("possible")
    void name() {
        sut.save(FooFixtures.newFoo(1, "jang", 20));

        Optional<Foo> actual = sut.findBy(FooId.of(1));

        assertThat(actual.isPresent()).isTrue();

        assertThat(actual.get().getId()).isEqualTo(FooId.of(1));
        assertThat(actual.get().getInformation().getName()).isEqualTo(Name.of("jang"));
        assertThat(actual.get().getInformation().getAge()).isEqualTo(Age.of(20));
    }
}