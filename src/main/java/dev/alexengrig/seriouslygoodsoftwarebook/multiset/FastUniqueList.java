package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FastUniqueList<E> {
    private Set<E> values;
    private List<E> valueByIndex;

    public FastUniqueList(int capacity) {
        values = new HashSet<>(capacity);
        valueByIndex = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            valueByIndex.add(null);
        }
    }

    public boolean set(int index, E element) {
        if (index < 0 || index >= valueByIndex.size() || values.contains(element)) {
            return false;
        }
        E oldElement = valueByIndex.set(index, element);
        values.remove(oldElement);
        values.add(element);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= valueByIndex.size()) {
            return null;
        }
        return valueByIndex.get(index);
    }
}
