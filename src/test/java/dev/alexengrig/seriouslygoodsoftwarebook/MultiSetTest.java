package dev.alexengrig.seriouslygoodsoftwarebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiSetTest {
    @Test
    void test() {
        MultiSet<String> multiSet = new MultiSet<>();
        multiSet.add("One");
        multiSet.add("Two");
        multiSet.add("Two");
        multiSet.add("Three");
        multiSet.add("Three");
        multiSet.add("Three");
        assertEquals(1, multiSet.count("One"));
        assertEquals(2, multiSet.count("Two"));
        assertEquals(3, multiSet.count("Three"));
    }
}