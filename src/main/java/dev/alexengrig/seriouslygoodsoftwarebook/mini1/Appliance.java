package dev.alexengrig.seriouslygoodsoftwarebook.mini1;

public class Appliance {
    private final int powerAbsorbed;
    private boolean isOn;
    private Grid grid;

    public Appliance(int powerAbsorbed) {
        this.powerAbsorbed = powerAbsorbed;
    }

    public void plugInto(Grid otherGrid) {
        if (grid != null && isOn) {
            grid.addPower(powerAbsorbed);
        }
        grid = otherGrid;
        if (isOn) {
            otherGrid.addPower(-powerAbsorbed);
        }
    }

    public void on() {
        requireHasGrid();
        if (!isOn) {
            grid.addPower(-powerAbsorbed);
            isOn = true;
        }
    }

    public void off() {
        requireHasGrid();
        if (isOn) {
            grid.addPower(powerAbsorbed);
            isOn = false;
        }
    }

    private void requireHasGrid() {
        if (grid == null) {
            throw new IllegalStateException("No grid");
        }
    }
}
