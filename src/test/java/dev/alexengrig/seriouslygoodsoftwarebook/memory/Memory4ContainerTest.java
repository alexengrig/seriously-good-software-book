package dev.alexengrig.seriouslygoodsoftwarebook.memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Memory4ContainerTest {
    @Test
    void test() {
        int container1 = Memory4Container.newContainer();
        int container2 = Memory4Container.newContainer();
        int container3 = Memory4Container.newContainer();
        Memory4Container.connect(container1, container2);
        Memory4Container.addWater(container1, 5);
        Memory4Container.addWater(container2, 15);
        Memory4Container.addWater(container3, 25);
        assertEquals(10, Memory4Container.getAmount(container1));
        assertEquals(10, Memory4Container.getAmount(container2));
        assertEquals(25, Memory4Container.getAmount(container3));
    }
}