package dev.alexengrig.seriouslygoodsoftwarebook.speed;

import dev.alexengrig.seriouslygoodsoftwarebook.Container;

public class LightweightSpeed3Container implements Container<LightweightSpeed3Container> {
    protected RootContainer parent;

    public LightweightSpeed3Container() {
        this(new RootContainer());
    }

    protected LightweightSpeed3Container(RootContainer root) {
        parent = root;
    }

    @Override
    public void connectTo(LightweightSpeed3Container other) {
        RootContainer root1 = findRootAndCompress();
        RootContainer root2 = other.findRootAndCompress();
        if (root1 == root2) {
            return;
        }
        int size1 = root1.size;
        int size2 = root2.size;
        double total1 = size1 * root1.amount;
        double total2 = size2 * root2.amount;
        double newAmount = (total1 + total2) / (size1 + size2);
        if (size1 <= size2) {
            root1.parent = root2;
            root2.amount = newAmount;
            root2.size += size1;
        } else {
            root2.parent = root1;
            root1.amount = newAmount;
            root1.size += size2;
        }
    }

    @Override
    public void addWater(double amount) {
        RootContainer root = findRootAndCompress();
        root.amount += amount / root.size;
    }

    @Override
    public double getAmount() {
        RootContainer root = findRootAndCompress();
        return root.amount;
    }

    @Override
    public int groupSize() {
        RootContainer root = findRootAndCompress();
        return root.size;
    }

    @Override
    public void flush() {
        RootContainer root = findRootAndCompress();
        root.amount = 0;
    }

    protected boolean isRoot() {
        return parent.parent == parent;
    }

    protected RootContainer findRootAndCompress() {
        if (isRoot()) {
            return parent;
        } else if (parent.isRoot()) {
            return parent.parent;
        } else {
            parent = parent.findRootAndCompress();
            return parent;
        }
    }

    private static class RootContainer extends LightweightSpeed3Container {
        int size = 1;
        double amount;

        RootContainer() {
            super(null);
            super.parent = this;
        }
    }
}
