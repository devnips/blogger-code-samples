package com.blogspot.devnip.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Split a list into chunks of fixed size.
 */
public class SplitListToChunks {

    public static <T> List<List<T>> split(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger();
        return new ArrayList<>(
                list.stream()
                        .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                        .values());
    }
}
