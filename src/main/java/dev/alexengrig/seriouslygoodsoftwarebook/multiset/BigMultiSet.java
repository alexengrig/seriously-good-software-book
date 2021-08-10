package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

import java.util.ArrayList;
import java.util.List;

public class BigMultiSet<T> {
    private final List<T> data = new ArrayList<>();
    private final List<Long> repetitions = new ArrayList<>();

    public void add(T element) {
        int indexOfElement = data.indexOf(element);
        if (indexOfElement >= 0) {
            Long value = repetitions.get(indexOfElement);
            repetitions.set(indexOfElement, value + 1);
        } else {
            data.add(element);
            repetitions.add(1L);
        }
    }

    public long count(T element) {
        int indexOfElement = data.indexOf(element);
        if (indexOfElement >= 0) {
            return repetitions.get(indexOfElement);
        } else {
            return 0;
        }
    }
}
