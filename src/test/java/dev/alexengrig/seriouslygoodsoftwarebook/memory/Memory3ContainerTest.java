package dev.alexengrig.seriouslygoodsoftwarebook.memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Memory3ContainerTest {
    @Test
    void test() {
        int container1 = Memory3Container.newContainer();
        int container2 = Memory3Container.newContainer();
        int container3 = Memory3Container.newContainer();
        Memory3Container.connect(container1, container2);
        Memory3Container.addWater(container1, 5);
        Memory3Container.addWater(container2, 15);
        Memory3Container.addWater(container3, 25);
        assertEquals(10, Memory3Container.getAmount(container1));
        assertEquals(10, Memory3Container.getAmount(container2));
        assertEquals(25, Memory3Container.getAmount(container3));
    }

}