package com.github.moimp.aggregate.fixture;

public class FooFixtures {
    public static Foo newFoo(long id, String name, int age) {
        return new Foo(FooId.of(id), Information.of(Name.of(name), Age.of(age)));
    }
}
