package com.github.moimp.mapping.instantiator;

import com.github.moimp.aggregate.Aggregate;
import com.github.moimp.mapping.serializer.GsonSerializer;
import com.github.moimp.mapping.serializer.Serializer;
import com.github.moimp.record.AggregateRecord;

public interface Instantiator<ID, AGGREGATE extends Aggregate<ID>> {
    AGGREGATE instantiate(AggregateRecord<ID> record);
}
