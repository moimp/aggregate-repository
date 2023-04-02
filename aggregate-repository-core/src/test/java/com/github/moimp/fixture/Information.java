package com.github.moimp.fixture;

import lombok.Value;

@Value(staticConstructor = "of")
public class Information {
    Name name;
    Age age;
}

