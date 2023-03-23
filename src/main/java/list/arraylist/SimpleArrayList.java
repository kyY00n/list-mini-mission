package list.arraylist;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;

    private String[] array = new String[DEFAULT_CAPACITY];
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;

    @Override
    public boolean add(String value) {
        if (array.length == size) {
            applyNewCapacity();
        }
        array[size++] = value;
        return true;
    }

    private void applyNewCapacity() {
        int newCapacity = (int) (capacity * 1.5);
        array = Arrays.copyOf(array, newCapacity);
        capacity = newCapacity;
    }

    @Override
    public void add(int targetIndex, String value) {
        if (targetIndex < 0 || targetIndex > size) {
            throw new IndexOutOfBoundsException();
        }
        if (array.length == size) {
            applyNewCapacity();
        }
        for (int index = size - 1; index >= targetIndex; index--) {
            array[index + 1] = array[index];
        }
        array[targetIndex] = value;
        size += 1;
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
        return array[index];
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
        int targetIndex;
        int index;
        for (index = 0; index < size; index++) {
            if (array[index].equals(value)) {
                break;
            }
        }
        if (index == size) {
            return false;
        }
        targetIndex = index;
        for (int next = targetIndex; next < size; next++) {
            array[next] = array[next + 1];
        }
        array[--size] = null;
        return true;
    }

    @Override
    public String remove(int targetIndex) {
        if (targetIndex < 0 || targetIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        String removed = array[targetIndex];
        for (int index = targetIndex; index < size - 1; index++) {
            array[targetIndex] = array[targetIndex + 1];
        }
        size -= 1;
        return removed;
    }

    @Override
    public void clear() {

    }
}
