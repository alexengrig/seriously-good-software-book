package dev.alexengrig.seriouslygoodsoftwarebook.mini1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridAndApplianceTest {
    @Test
    void test() {
        Appliance tv = new Appliance(150);
        Appliance radio = new Appliance(30);
        Grid grid1 = new Grid(3000);
        tv.plugInto(grid1);
        radio.plugInto(grid1);
        assertEquals(3000, grid1.residualPower());
        tv.on();
        assertEquals(2850, grid1.residualPower());
        radio.on();
        assertEquals(2820, grid1.residualPower());
        radio.off();
        assertEquals(2850, grid1.residualPower());

        Grid grid2 = new Grid(2000);
        tv.plugInto(grid2);
        assertEquals(3000, grid1.residualPower());
        assertEquals(1850, grid2.residualPower());
        radio.plugInto(grid2);
        assertEquals(1850, grid2.residualPower());
        radio.on();
        assertEquals(1820, grid2.residualPower());
    }
}