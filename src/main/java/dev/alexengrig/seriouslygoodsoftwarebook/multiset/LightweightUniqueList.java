package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import java.util.ArrayList;
import java.util.List;

public class LightweightUniqueList<E> {
    private List<E> values;

    public LightweightUniqueList(int capacity) {
        values = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            values.add(null);
        }
    }

    public boolean set(int index, E element) {
        if (index < 0 || index >= values.size() || values.contains(element)) {
            return false;
        }
        values.set(index, element);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= values.size()) {
            return null;
        }
        return values.get(index);
    }
}
