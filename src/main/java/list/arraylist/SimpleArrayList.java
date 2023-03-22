package list.arraylist;

import java.util.Arrays;
import java.util.Objects;

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
        if (index >= capacity || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        String value = array[index];
        if (Objects.isNull(value)) {
            throw new IndexOutOfBoundsException();
        }
        return value;
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
        int index = 0;
        while (index < capacity && isNotNullIndexOf(index)) {
            index++;
        }
        return index;
    }

    private boolean isNotNullIndexOf(int index) {
        return array[index] != null;
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
