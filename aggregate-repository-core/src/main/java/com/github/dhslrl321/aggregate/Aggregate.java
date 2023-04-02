package com.github.dhslrl321.aggregate;

public interface Aggregate<ID> {

    long FIRST_VERSION = 0;

    ID getId();

    long getVersion();
}
