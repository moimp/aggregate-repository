package com.github.dhslrl321.record;

import java.util.Optional;

public interface AggregateRecordRepository<ID> {

    void save(AggregateRecord<ID> record);

    Optional<AggregateRecord<ID>> findBy(ID id);
}
