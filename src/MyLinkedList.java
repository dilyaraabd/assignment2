public class MyLinkedList<T extends Comparable<? super T>> implements MyList<T> {
    private static class MyNode<T> {
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> temp = head;
        int index = 0;

        while (index < length) {
            if (temp.data == o) return index;
            temp = temp.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> temp = head;
        int index = 0;
        int lastIndex = -1;

        while (index < length) {
            if (temp.data == o) lastIndex = index;
            temp = temp.next;
            index++;
        }

        return lastIndex;
    }

    @Override
    public void sort() {
        boolean sorted = false;
        if (length > 1)
            while (!sorted) {
                sorted = true;
                MyNode<T> temp = head;
                while (temp.next != null) {
                    if (temp.data.compareTo(temp.next.data) > 0) {
                        T swap = temp.data;
                        temp.data = temp.next.data;
                        temp.next.data = swap;
                        sorted = false;
                    }
                    temp = temp.next;
                }
            }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>((T) item);
        if (index > length || index < 0) return;
        if (head == null) {
            head = tail = newNode;
        } else {
            MyNode<T> temp = head;
            int tempIndex = 0;
            while (tempIndex < index - 1) {
                temp = temp.next;
                tempIndex++;
            }
            MyNode<T> after = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            if (after != null) {
                after.prev = newNode;
                newNode.next = after;
            } else {
                newNode.next = null;
                tail = newNode;
            }
        }
        length++;
    }

    @Override
    public boolean remove(T item) {
        boolean isFound = false;
        MyNode<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == item) {
                isFound = true;
                length--;
                remove(index);
            }
            temp = temp.next;
            index++;
        }
        return isFound;
    }

    @Override
    public T remove(int index) {
        if (index >= length || index < 0) {
            return null;
        } else {
            MyNode<T> temp = head;
            int tempIndex = 0;
            while (tempIndex < index) {
                temp = temp.next;
                tempIndex++;
            }
            MyNode<T> after;
            MyNode<T> before;
            length--;
            if (temp.next == null) {
                before = temp.prev;
                T result = temp.data;
                before.next = null;
                tail = before;
                return result;
            }
            if (temp.prev == null) {
                after = temp.next;
                T result = temp.data;
                after.prev = null;
                head = after;
                return result;
            }
            after = temp.next;
            before = temp.prev;
            T result = temp.data;
            before.next = after;
            after.prev = before;
            return result;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }
}