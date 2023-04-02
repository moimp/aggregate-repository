package com.github.moimp.aggregate.fixture;

import lombok.Value;

@Value(staticConstructor = "of")
public class FooId {
    long value;
}
