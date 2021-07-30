package dev.alexengrig.seriouslygoodsoftwarebook;

public class Speed3Container implements Container<Speed3Container> {
    private Speed3Container parent = this;
    private int size = 1;
    private double amount;

    @Override
    public void connectTo(Speed3Container other) {
        Speed3Container root1 = findRootAndCompress();
        Speed3Container root2 = other.findRootAndCompress();
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
        Speed3Container root = findRootAndCompress();
        root.amount += amount / root.size;
    }

    @Override
    public double getAmount() {
        Speed3Container root = findRootAndCompress();
        return root.amount;
    }

    @Override
    public int groupSize() {
        Speed3Container root = findRootAndCompress();
        return root.size - 1;
    }

    @Override
    public void flush() {
        Speed3Container root = findRootAndCompress();
        root.amount = 0;
    }

    private Speed3Container findRootAndCompress() {
        if (parent != this) {
            parent = parent.findRootAndCompress();
        }
        return parent;
    }
}
