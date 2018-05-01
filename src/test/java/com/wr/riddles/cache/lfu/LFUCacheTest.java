package com.wr.riddles.cache.lfu;

import com.wr.riddles.cache.Cache;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class LFUCacheTest {

    private static Stream<Arguments> cache() {
        return Stream.of(
                Arguments.of(new MapBasedLFUCache<>(3)),
                Arguments.of(new PriorityQueueLFUCache<>(3)),
                Arguments.of(new LinkedListBasedLFUCache<>(3))
        );
    }

    @ParameterizedTest
    @MethodSource("cache")
    void testGet(Cache<String, String> cache) {
        cache.add("1", "1");
        cache.add("2", "2");
        cache.add("3", "3");

        assertThat(cache.get("1"), equalTo("1"));
        assertThat(cache.get("2"), equalTo("2"));
        assertThat(cache.get("3"), equalTo("3"));

        cache.get("2");
        cache.get("1");

        cache.add("4", "4");
        assertThat(cache.get("1"), equalTo("1"));
        assertNull(cache.get("3"));
        assertThat(cache.get("2"), equalTo("2"));
        assertThat(cache.get("4"), equalTo("4"));
    }

}