package com.github.moimp.supports;

import com.github.moimp.aggregate.Aggregate;
import com.github.moimp.record.AggregateRecord;

public interface Shaper<ID, AGGREGATE extends Aggregate<ID>> {
    AGGREGATE shape(AggregateRecord<ID> record);
}
