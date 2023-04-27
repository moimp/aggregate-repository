package com.github.moimp.general;

import com.github.moimp.aggregate.Aggregate;
import com.github.moimp.aggregate.AggregateRepository;
import com.github.moimp.record.AggregateRecord;
import com.github.moimp.record.AggregateRecordRepository;
import com.github.moimp.mapping.instantiator.Instantiator;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class GeneralAggregateRepository<ID, AGGREGATE extends Aggregate<ID>> implements AggregateRepository<ID, AGGREGATE> {

    private final AggregateRecordRepository<ID> repository;
    private final Instantiator<ID, AGGREGATE> instantiator;

    @Override
    public void save(AGGREGATE aggregate) {
        AggregateRecord<ID> record = AggregateRecord.recordOf(aggregate);
        repository.save(record);
    }

    @Override
    public Optional<AGGREGATE> findBy(ID id) {
        Optional<AggregateRecord<ID>> found = repository.findBy(id);
        try {
            AggregateRecord<ID> record = found.get();
            return Optional.of(instantiator.instantiate(record));
        } catch (RuntimeException e) {
            throw new RuntimeException("구체화 실패");
        }
    }
}
