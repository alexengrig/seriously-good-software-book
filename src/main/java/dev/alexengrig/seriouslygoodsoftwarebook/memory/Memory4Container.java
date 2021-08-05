package dev.alexengrig.seriouslygoodsoftwarebook.memory;

import java.util.Arrays;

public class Memory4Container {
    private static float[] nextOrAmount = new float[0];

    private Memory4Container() {
    }

    public static int newContainer() {
        int nContainers = nextOrAmount.length;
        nextOrAmount = Arrays.copyOf(nextOrAmount, nContainers + 1);
        return nContainers;
    }

    public static float getAmount(int containerID) {
        while (nextOrAmount[containerID] > 0) {
            containerID = (int) nextOrAmount[containerID] - 1;
        }
        return -nextOrAmount[containerID];
    }

    public static void addWater(int containerID, float amount) {
        int firstOfGroup = findFirstOfGroup(containerID);
        int[] lastAndSize = findLastOfGroupAndCount(firstOfGroup);
        nextOrAmount[lastAndSize[0]] -= amount / lastAndSize[1];
    }

    public static void connect(int containerID1, int containerID2) {
        int first1 = findFirstOfGroup(containerID1);
        int first2 = findFirstOfGroup(containerID2);
        if (first1 == first2) {
            return;
        }
        int[] lastAndSize1 = findLastOfGroupAndCount(first1);
        int[] lastAndSize2 = findLastOfGroupAndCount(first2);
        int last1 = lastAndSize1[0];
        int last2 = lastAndSize2[0];
        float amount1 = -nextOrAmount[last1];
        float amount2 = -nextOrAmount[last2];
        int size1 = lastAndSize1[1];
        int size2 = lastAndSize2[1];
        float total1 = amount1 * size1;
        float total2 = amount2 * size2;
        float newAmount = (total1 + total2) / (size1 + size2);
        nextOrAmount[last1] = first2 + 1;
        nextOrAmount[last2] = -newAmount;
    }

    private static int findFirstOfGroup(int containerID) {
        int current = containerID;
        int i;
        do {
            for (i = 0; i < nextOrAmount.length; i++)
                if (nextOrAmount[i] == current + 1) {
                    current = i;
                    break;
                }
        } while (i < nextOrAmount.length);
        return current;
    }

    private static int[] findLastOfGroupAndCount(int containerID) {
        int current = containerID;
        int count = 1;
        while (nextOrAmount[current] > 0) {
            current = (int) nextOrAmount[current] - 1;
            count++;
        }
        return new int[]{current, count};
    }
}
