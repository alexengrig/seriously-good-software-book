package dev.alexengrig.seriouslygoodsoftwarebook;

public interface Container<C extends Container<C>> {
    void connectTo(C other);

    void addWater(double amount);

    double getAmount();
}
