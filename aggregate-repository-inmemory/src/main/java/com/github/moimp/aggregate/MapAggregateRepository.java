package com.github.moimp.aggregate;

import com.github.moimp.record.AbstractAggregateRecordRepository;
import com.github.moimp.record.AggregateRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapAggregateRepository<ID> extends AbstractAggregateRecordRepository<ID> {

    private final Map<ID, AggregateRecord<ID>> records = new HashMap<>();

    @Override
    protected void modify(AggregateRecord<ID> versioned) {
        Optional<AggregateRecord<ID>> record = findBy(versioned.getId());
        if (record.isEmpty()) {
            throw new IllegalStateException();
        }
        record.ifPresent((r) -> {
            records.put(r.getId(), r);
        });
    }

    @Override
    protected void newInsert(AggregateRecord<ID> versioned) {
        records.put(versioned.getId(), versioned);
    }

    @Override
    protected AggregateRecord<ID> queryOneBy(ID id) {
        AggregateRecord<ID> find = records.get(id);
        if (find == null) {
            return null;
        }
        return AggregateRecord.of(
                find.getId(),
                find.getSerialized(),
                find.getVersion(),
                find.getOccurredAt(),
                find.getCreatedAt(),
                find.getModifiedAt());
    }
}
