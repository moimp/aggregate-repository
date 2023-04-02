package com.github.moimp.record;

import java.util.Optional;

public abstract class AbstractAggregateRecordRepository<ID> implements AggregateRecordRepository<ID> {

    @Override
    public void save(AggregateRecord<ID> record) {
        if (record.isNew()) {
            newInsert(record);
        } else {
            modify(record);
        }
    }

    @Override
    public Optional<AggregateRecord<ID>> findBy(ID id) {
        return Optional.ofNullable(queryOnBy(id));
    }

    abstract protected void modify(AggregateRecord<ID> record);

    abstract protected void newInsert(AggregateRecord<ID> record);

    abstract protected AggregateRecord<ID> queryOnBy(ID id);
}
