package com.github.moimp.fixture;

import lombok.Value;

@Value(staticConstructor = "of")
public class Age {
    long value;
}