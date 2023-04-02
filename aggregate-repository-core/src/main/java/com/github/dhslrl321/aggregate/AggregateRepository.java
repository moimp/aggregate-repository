package com.github.dhslrl321.aggregate;

import java.util.Optional;

public interface AggregateRepository<ID, AGGREGATE> {

    void save(AGGREGATE aggregate);

    Optional<AGGREGATE> findBy(ID id);

}
