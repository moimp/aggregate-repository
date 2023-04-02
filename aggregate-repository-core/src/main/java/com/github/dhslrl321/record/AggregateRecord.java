package com.github.dhslrl321.record;

import com.github.dhslrl321.aggregate.Aggregate;
import com.github.dhslrl321.supports.SerializerHolder;
import lombok.Value;

import java.time.LocalDateTime;

import static com.github.dhslrl321.aggregate.Aggregate.FIRST_VERSION;

@Value
public class AggregateRecord<ID> {
    ID id;
    String serialized;
    long version;
    LocalDateTime createdAt;
    LocalDateTime occurredAt;
    LocalDateTime modifiedAt;

    public static <ID, AGGREGATE extends Aggregate<ID>> AggregateRecord<ID> recordOf(AGGREGATE aggregate) {
        ID id = aggregate.getId();
        long version = aggregate.getVersion();
        // TODO v up
        String serialized = SerializerHolder.getSerializer().serialize(aggregate);
        LocalDateTime occurredAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        LocalDateTime createdAt = null;

        if (isNew(version)) {
            createdAt = occurredAt;
        }
        return new AggregateRecord<>(id, serialized, version, createdAt, occurredAt, modifiedAt);
    }

    public boolean isNew() {
        return isNew(this.version);
    }

    private static boolean isNew(long version) {
        return version == FIRST_VERSION;
    }
}
