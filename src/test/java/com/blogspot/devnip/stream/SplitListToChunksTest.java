package com.blogspot.devnip.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SplitListToChunksTest {

    @Test
    void test_split() {
        List<String> original = Arrays.asList("A", "B", "C", "D", "E");
        List<List<String>> chunks = SplitListToChunks.split(original, 2);

        Assertions.assertEquals(3, chunks.size());
        Assertions.assertEquals(2, chunks.get(0).size());
        Assertions.assertEquals(2, chunks.get(1).size());
        Assertions.assertEquals(1, chunks.get(2).size());
    }
}