package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import java.util.ArrayList;
import java.util.List;

public class MultiSet<T> {
    private final List<T> data = new ArrayList<>();

    public void add(T element) {
        data.add(element);
    }

    public long count(T element) {
        long count = 0;
        for (T datum : data) {
            if (datum.equals(element)) {
                count++;
            }
        }
        return count;
    }
}
