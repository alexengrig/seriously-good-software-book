package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigMultiSetTest {
    @Test
    void test() {
        BigMultiSet<String> multiSet = new BigMultiSet<>();
        multiSet.add("One");
        multiSet.add("Two");
        multiSet.add("Two");
        multiSet.add("Three");
        multiSet.add("Three");
        multiSet.add("Three");
        assertEquals(0, multiSet.count("Zero"));
        assertEquals(1, multiSet.count("One"));
        assertEquals(2, multiSet.count("Two"));
        assertEquals(3, multiSet.count("Three"));
    }
}