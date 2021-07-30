package dev.alexengrig.seriouslygoodsoftwarebook;

import java.util.HashSet;
import java.util.Set;

public class Speed1Container implements Container<Speed1Container> {
    private Group group;

    public Speed1Container() {
        group = new Group(this);
    }

    @Override
    public void connectTo(Speed1Container other) {
        if (group == other.group) {
            return;
        }
        int size1 = group.members.size();
        int size2 = other.group.members.size();
        double total1 = size1 * group.amountPerContainer;
        double total2 = size2 * other.group.amountPerContainer;
        group.amountPerContainer = (total1 + total2) / (size1 + size2);
        group.members.addAll(other.group.members);
        for (Speed1Container member : other.group.members) {
            member.group = group;
        }
    }

    @Override
    public void addWater(double amount) {
        double amountPerContainer = amount / group.members.size();
        group.amountPerContainer += amountPerContainer;
    }

    @Override
    public double getAmount() {
        return group.amountPerContainer;
    }

    private static class Group {
        Set<Speed1Container> members;
        double amountPerContainer;

        Group(Speed1Container container) {
            members = new HashSet<>();
            members.add(container);
        }
    }
}
