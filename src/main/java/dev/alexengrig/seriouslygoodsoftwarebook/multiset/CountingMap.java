package dev.alexengrig.seriouslygoodsoftwarebook.multiset;

public class CountingMap<E> {
    private int size;
    private Object[] keys;
    private long[] values;

    public CountingMap() {
        this(16);
    }

    public CountingMap(int capacity) {
        keys = new Object[capacity];
        values = new long[capacity];
    }

    public long add(E element) {
        requireCapacity();
        int indexOfElement = indexOf(element);
        Object key = keys[indexOfElement];
        if (key == null) {
            size++;
            keys[indexOfElement] = element;
            values[indexOfElement] = 1;
            return 0;
        }
        return values[indexOfElement]++;
    }

    public long count(E element) {
        int indexOfElement = indexOf(element);
        Object key = keys[indexOfElement];
        if (key == null || !key.equals(element)) {
            return 0;
        }
        return values[indexOfElement];
    }

    private int indexOf(E element) {
        int index = element.hashCode() % keys.length;
        Object key = keys[index];
        if (key == null || key.equals(element)) {
            return index;
        }
        int startIndex = index;
        do {
            index = (index + 1) % keys.length;
            if (index == startIndex) {
                break;
            }
            key = keys[index];
        } while (key != null && !key.equals(element));
        return index;
    }

    private void requireCapacity() {
        if (size == keys.length) {
            grow();
        }
    }

    private void grow() {
        int newCapacity = keys.length * 2;
        Object[] newKeys = new Object[newCapacity];
        long[] newValues = new long[newCapacity];
        for (int index = 0; index < values.length; index++) {
            Object key = keys[index];
            int newIndex = key.hashCode() % newCapacity;
            while (newKeys[newIndex] != null) {
                newIndex = (newIndex + 1) % newCapacity;
            }
            newKeys[newIndex] = key;
            newValues[newIndex] = values[index];
        }
        keys = newKeys;
        values = newValues;
    }
}
