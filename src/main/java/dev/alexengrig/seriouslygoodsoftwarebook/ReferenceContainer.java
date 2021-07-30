package dev.alexengrig.seriouslygoodsoftwarebook;

import java.util.HashSet;
import java.util.Set;

public class ReferenceContainer implements Container<ReferenceContainer> {
    private Set<ReferenceContainer> group;
    private double amount;

    public ReferenceContainer() {
        group = new HashSet<>();
        group.add(this);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void connectTo(ReferenceContainer other) {
        if (group == other.group) {
            return;
        }
        int size1 = group.size();
        int size2 = other.group.size();
        double total1 = amount * size1;
        double total2 = other.amount * size2;
        double newAmount = (total1 + total2) / (size1 + size2);
        group.addAll(other.group);
        for (ReferenceContainer container : other.group) {
            container.group = group;
        }
        for (ReferenceContainer container : group) {
            container.amount = newAmount;
        }
    }

    @Override
    public void addWater(double amount) {
        double amountPerContainer = amount / group.size();
        for (ReferenceContainer container : group) {
            container.amount += amountPerContainer;
        }
    }

    @Override
    public int groupSize() {
        return group.size() - 1;
    }

    @Override
    public void flush() {
        for (ReferenceContainer container : group) {
            container.amount = 0;
        }
    }
}
