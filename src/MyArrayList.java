public class MyArrayList<T extends Comparable<? super T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }


    public void add(T item) {
        arr[length++] = item;
        if (length == capacity)
            increaseCapacity();
    }

    @Override
    public void add(T item, int index) {
        if (index > length || index < 0) return;
        length++;
        if (length == capacity) increaseCapacity();
        Object[] newArr = new Object[capacity];
        for (int i = 0; i < length + 1; i++) {
            if (i < index) newArr[i] = arr[i];
            else if (i == index) newArr[i] = item;
            else newArr[i] = arr[i - 1];
        }
        for (int i = 0; i < length + 1; i++) {
            arr[i] = newArr[i];
        }
    }

    @Override
    public boolean remove(T item) {
        boolean isFound = false;
        for (int i = 0; i < length; i++) {
            if (item.compareTo((T) arr[i]) == 0) isFound = true;
            if (isFound) {
                if (i == length - 1) arr[i] = null;
                else arr[i] = arr[i + 1];
            }
        }
        if (isFound) length -= 1;
        return isFound;
    }

    @Override
    public T remove(int index) {
        T result = null;
        boolean isFound = false;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                isFound = true;
                result = (T) arr[i];
            }
            if (isFound) {
                if (i == length - 1) arr[i] = null;
                else arr[i] = arr[i + 1];
            }
        }
        if (result != null) length -= 1;
        return result;
    }

    @Override
    public void clear() {
        length = 0;
        capacity = 3;
        arr = new Object[capacity];
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (o == arr[i]) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (o == arr[i]) lastIndex = i;
        }
        return lastIndex;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (((T) arr[j]).compareTo((T) arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
}
