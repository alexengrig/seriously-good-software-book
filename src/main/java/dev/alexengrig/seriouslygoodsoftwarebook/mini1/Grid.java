package dev.alexengrig.seriouslygoodsoftwarebook.mini1;

public class Grid {
    private final int maxPower;
    private int residualPower;

    public Grid(int maxPower) {
        this.maxPower = maxPower;
        this.residualPower = maxPower;
    }

    public int residualPower() {
        return residualPower;
    }

    void addPower(int power) {
        if (residualPower + power < 0) {
            throw new IllegalArgumentException("Not enough power");
        }
        if (residualPower + power > maxPower) {
            throw new IllegalArgumentException("Maximum power exceeded");
        }
        residualPower += power;
    }
}
