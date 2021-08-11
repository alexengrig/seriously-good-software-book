package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingMapTest {
    @Test
    void test() {
        CountingMap<String> map = new CountingMap<>(3);
        assertEquals(0, map.add("One"));
        assertEquals(0, map.add("Two"));
        assertEquals(1, map.add("Two"));
        assertEquals(0, map.add("Three"));
        assertEquals(1, map.add("Three"));
        assertEquals(2, map.add("Three"));

        assertEquals(1, map.count("One"));
        assertEquals(2, map.count("Two"));
        assertEquals(3, map.count("Three"));

        assertEquals(0, map.add("Four"));
        assertEquals(1, map.add("Four"));
        assertEquals(2, map.add("Four"));
        assertEquals(3, map.add("Four"));
        assertEquals(4, map.count("Four"));
    }
}