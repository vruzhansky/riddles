package com.wr.riddles.cache.lfu;

import com.wr.riddles.cache.Cache;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertNull;

public class LFUCacheTest {

    @DataProvider(name = "cache")
    public static Object[][] cache() {
        return new Object[][]{
                {new MapBasedLFUCache<>(3)},
                {new PriorityQueueLFUCache<>(3)},
                {new LinkedListBasedLFUCache<>(3)},

        };
    }

    @Test(dataProvider = "cache")
    public void testGet(Cache<String, String> cache) throws Exception {
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