package com.github.dhslrl321.fixture;

import lombok.Value;

@Value(staticConstructor = "of")
public class Age {
    long value;
}