package com.github.moimp.aggregate;

public interface Aggregate<ID> {

    long FIRST_VERSION = 0;

    ID getId();

    long getVersion();
}
