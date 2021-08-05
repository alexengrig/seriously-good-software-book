package dev.alexengrig.seriouslygoodsoftwarebook.memory;

public interface Container<C extends Container<C>> {
    void connectTo(C other);

    void addWater(float amount);

    float getAmount();
}
