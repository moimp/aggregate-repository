package com.github.moimp.template;

import com.github.moimp.aggregate.Aggregate;
import com.github.moimp.aggregate.AggregateRepository;
import com.github.moimp.record.AggregateRecord;
import com.github.moimp.record.AggregateRecordRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AggregateRepositoryTemplate<ID, AGGREGATE extends Aggregate<ID>> implements AggregateRepository<ID, AGGREGATE> {

    private final AggregateRecordRepository<ID> repository;

    @Override
    public void save(AGGREGATE aggregate) {
        AggregateRecord<ID> record = AggregateRecord.recordOf(aggregate);
        repository.save(record);
    }

    @Override
    public Optional<AGGREGATE> findBy(ID id) {
        Optional<AggregateRecord<ID>> found = repository.findBy(id);
        // deserialize
        return Optional.empty();
    }
}
