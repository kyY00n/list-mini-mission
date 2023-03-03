package list.arraylist;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;
    String[] array = new String[DEFAULT_CAPACITY];
    private int capacity = DEFAULT_CAPACITY;

    @Override
    public boolean add(String value) {
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                array[i] = value;
                return true;
            }
        }
        int newCapacity = (int) (capacity * 1.5);
        array = Arrays.copyOf(array, newCapacity);
        array[capacity] = value;
        capacity = newCapacity;
        return true;
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < capacity && array[index] != null; index++) {
            if (array[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
