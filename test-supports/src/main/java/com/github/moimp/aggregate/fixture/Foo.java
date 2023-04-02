package com.github.moimp.aggregate.fixture;

import com.github.moimp.aggregate.Aggregate;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Foo implements Aggregate<FooId> {

    private final FooId id;
    private final Information information;
    private long version;

    public Foo(FooId id, Information information) {
        this.id = id;
        this.information = information;
    }

    @Override
    public FooId getId() {
        return id;
    }

    @Override
    public long getVersion() {
        return version;
    }
}
