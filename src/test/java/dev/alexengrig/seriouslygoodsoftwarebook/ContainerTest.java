package dev.alexengrig.seriouslygoodsoftwarebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ContainerTest<C extends Container<C>> {
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
    }
}