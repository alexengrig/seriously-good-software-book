package dev.alexengrig.seriouslygoodsoftwarebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ContainerTest<C extends Container<C>> {
    protected abstract C createContainer();

    @Test
    void test() {
        C container1 = createContainer();
        C container2 = createContainer();
        C container3 = createContainer();
        container1.connectTo(container2);
        container1.addWater(5);
        container2.addWater(15);
        container3.addWater(25);
        assertEquals(10, container1.getAmount());
        assertEquals(10, container2.getAmount());
        assertEquals(25, container3.getAmount());
        container1.addWater(-2);
        container2.addWater(-2);
        container3.addWater(-5);
        assertEquals(8, container1.getAmount());
        assertEquals(8, container2.getAmount());
        assertEquals(20, container3.getAmount());
        assertEquals(2, container1.groupSize());
        assertEquals(2, container2.groupSize());
        assertEquals(1, container3.groupSize());
        container1.flush();
        container3.flush();
        assertEquals(0, container1.getAmount());
        assertEquals(0, container2.getAmount());
        assertEquals(0, container3.getAmount());
    }
}