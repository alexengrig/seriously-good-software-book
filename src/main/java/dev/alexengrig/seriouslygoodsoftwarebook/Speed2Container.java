package dev.alexengrig.seriouslygoodsoftwarebook;

public class Speed2Container implements Container<Speed2Container> {
    private Speed2Container next;
    private int size = 1;
    private double amount;

    public Speed2Container() {
        next = this;
    }

    @Override
    public void connectTo(Speed2Container other) {
        Speed2Container oldNext = this.next;
        next = other.next;
        other.next = oldNext;
    }

    @Override
    public void addWater(double amount) {
        this.amount += amount;
    }

    @Override
    public double getAmount() {
        updateGroup();
        return amount;
    }

    @Override
    public int groupSize() {
        updateGroup();
        return size - 1;
    }

    @Override
    public void flush() {
        Speed2Container current = this;
        do {
            current.amount = 0;
        } while ((current = current.next) != this);
    }

    private void updateGroup() {
        Speed2Container current = this;
        double totalAmount = 0;
        int sizeGroup = 0;
        do {
            totalAmount += current.amount;
            sizeGroup++;
        } while ((current = current.next) != this);
        double newAmount = totalAmount / sizeGroup;
        current = this;
        do {
            current.amount = newAmount;
            current.size = sizeGroup;
        } while ((current = current.next) != this);
    }
}
