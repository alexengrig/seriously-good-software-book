package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LightweightUniqueListTest {
    @Test
    void test() {
        LightweightUniqueList<String> list = new LightweightUniqueList<>(3);
        assertTrue(list.set(0, "Zero"));
        assertEquals("Zero", list.get(0));
        assertTrue(list.set(1, "One"));
        assertEquals("One", list.get(1));
        assertTrue(list.set(2, "Two"));
        assertEquals("Two", list.get(2));
    }
}