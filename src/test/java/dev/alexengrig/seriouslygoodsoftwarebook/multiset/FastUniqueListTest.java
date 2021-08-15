package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastUniqueListTest {
    @Test
    void test() {
        FastUniqueList<String> list = new FastUniqueList<>(3);
        assertTrue(list.set(0, "Zero"));
        assertEquals("Zero", list.get(0));
        assertTrue(list.set(1, "One"));
        assertEquals("One", list.get(1));
        assertTrue(list.set(2, "Two"));
        assertEquals("Two", list.get(2));
    }

    @Test
    void testSet() {
        FastUniqueList<String> list = new FastUniqueList<>(2);
        assertFalse(list.set(-1, "ignore"));
        assertFalse(list.set(2, "ignore"));
        assertTrue(list.set(0, "value"));
        assertFalse(list.set(1, "value"));
        assertTrue(list.set(0, "new_value"));
        assertTrue(list.set(1, "value"));
    }
}