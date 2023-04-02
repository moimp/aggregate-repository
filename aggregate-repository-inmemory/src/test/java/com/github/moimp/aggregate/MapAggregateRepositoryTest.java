package com.github.moimp.aggregate;

import com.github.moimp.aggregate.fixture.Foo;
import com.github.moimp.aggregate.fixture.FooFixtures;
import com.github.moimp.aggregate.fixture.FooId;
import com.github.moimp.supports.SerializerHolder;
import com.github.moimp.supports.Shaper;
import com.github.moimp.template.GeneralAggregateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MapAggregateRepositoryTest {

    GeneralAggregateRepository<FooId, Foo> sut;

    Shaper<FooId, Foo> fooShaper = record -> SerializerHolder.getSerializer().deserialize(record.getSerialized(), Foo.class);

    @BeforeEach
    void setUp() {
        sut = new GeneralAggregateRepository<>(new MapAggregateRepository<>(), fooShaper);
    }

    @Test
    void name() {
        sut.save(FooFixtures.newFoo(1, "jang", 20));

        Optional<Foo> actual = sut.findBy(FooId.of(1));

        assertThat(actual.isPresent()).isTrue();
    }
}