package dev.alexengrig.seriouslygoodsoftwarebook.memory;

import java.util.Arrays;

public class Memory3Container {
    private static int[] group = new int[0];
    private static float[] amount = new float[0];

    private Memory3Container() {
    }

    public static float getAmount(int containerID) {
        int groupID = group[containerID];
        return amount[groupID];
    }

    public static int newContainer() {
        int nGroups = amount.length;
        int nContainers = group.length;
        amount = Arrays.copyOf(amount, nGroups + 1);
        group = Arrays.copyOf(group, nContainers + 1);
        group[nContainers] = nGroups;
        return nContainers;
    }

    public static void connect(int containerID1, int containerID2) {
        int groupID1 = group[containerID1];
        int groupID2 = group[containerID2];
        if (groupID1 == groupID2) {
            return;
        }
        int size1 = groupSize(groupID1);
        int size2 = groupSize(groupID2);
        float amount1 = amount[groupID1] * size1;
        float amount2 = amount[groupID2] * size2;
        amount[groupID1] = (amount1 + amount2) / (size1 + size2);
        for (int i = 0; i < group.length; i++) {
            if (group[i] == groupID2) {
                group[i] = groupID1;
            }
        }
        removeGroupAndDefrag(groupID2);
    }

    private static int groupSize(int groupID) {
        int size = 0;
        for (int otherGroupID : group) {
            if (otherGroupID == groupID) {
                size++;
            }
        }
        return size;
    }

    private static void removeGroupAndDefrag(int groupID) {
        for (int containerID = 0; containerID < group.length; containerID++) {
            if (group[containerID] == amount.length - 1) {
                group[containerID] = groupID;
            }
        }
        amount[groupID] = amount[amount.length - 1];
        amount = Arrays.copyOf(amount, amount.length - 1);
    }

    public static void addWater(int containerID, float amount) {
        int groupID = group[containerID];
        int groupSize = groupSize(groupID);
        Memory3Container.amount[groupID] += amount / groupSize;
    }
}
