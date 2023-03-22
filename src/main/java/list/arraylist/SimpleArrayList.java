package list.arraylist;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;

    String[] array = new String[DEFAULT_CAPACITY];
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;

    @Override
    public boolean add(String value) {
        array[size++] = value;
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
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        String oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        String value = array[index];
        return value;
    }

    @Override
    public boolean contains(String value) {
        for (int index = 0; index < size; index++) {
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
