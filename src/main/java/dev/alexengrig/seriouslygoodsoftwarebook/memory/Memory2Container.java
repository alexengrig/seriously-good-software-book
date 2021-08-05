package dev.alexengrig.seriouslygoodsoftwarebook.memory;

public class Memory2Container implements Container<Memory2Container> {
    private Memory2Container[] group;
    private float amount;

    @Override
    public void connectTo(Memory2Container other) {
        if (group == null) {
            group = new Memory2Container[]{this};
        }
        if (other.group == null) {
            other.group = new Memory2Container[]{other};
        }
        if (group == other.group) {
            return;
        }
        int size1 = group.length;
        int size2 = other.group.length;
        float total1 = amount * size1;
        float total2 = other.amount * size2;
        float newAmount = (total1 + total2) / (size1 + size2);
        Memory2Container[] newGroup = new Memory2Container[size1 + size2];
        int i = 0;
        for (Memory2Container container : group) {
            container.group = newGroup;
            container.amount = newAmount;
            newGroup[i++] = container;
        }
        for (Memory2Container container : other.group) {
            container.group = newGroup;
            container.amount = newAmount;
            newGroup[i++] = container;
        }
    }

    @Override
    public void addWater(float amount) {
        if (group == null) {
            this.amount += amount;
        } else {
            float amountPerContainer = amount / group.length;
            for (Memory2Container container : group) {
                container.amount += amountPerContainer;
            }
        }
    }

    @Override
    public float getAmount() {
        return amount;
    }
}
