package dev.alexengrig.seriouslygoodsoftwarebook.memory;

import java.util.ArrayList;
import java.util.List;

public class Memory1Container implements Container<Memory1Container> {
    private List<Memory1Container> group;
    private float amount;

    @Override
    public void connectTo(Memory1Container other) {
        if (group == null) {
            group = new ArrayList<>();
            group.add(this);
        }
        if (other.group == null) {
            other.group = new ArrayList<>();
            other.group.add(other);
        }
        if (group == other.group) {
            return;
        }
        int size1 = group.size();
        int size2 = other.group.size();
        float total1 = amount * size1;
        float total2 = other.amount * size2;
        float newAmount = (total1 + total2) / (size1 + size2);
        group.addAll(other.group);
        for (Memory1Container container : other.group) {
            container.group = group;
        }
        for (Memory1Container container : group) {
            container.amount = newAmount;
        }
    }

    @Override
    public void addWater(float amount) {
        if (group == null) {
            this.amount += amount;
        } else {
            float amountPerContainer = amount / group.size();
            for (Memory1Container container : group) {
                container.amount += amountPerContainer;
            }
        }
    }

    @Override
    public float getAmount() {
        return amount;
    }
}
