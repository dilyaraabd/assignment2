import java.util.NoSuchElementException;

public class MyQueue<Item extends Comparable<? super Item>> {
    private MyLinkedList<Item> linkedList;

    public boolean add(Item item) {
        linkedList.add(item, 0);
        if (item == linkedList.get(0)) return true;
        throw new IllegalStateException("illegal state");
    }

    public boolean offer(Item item) {
        return add(item);
    }

    public Item remove() {
        if (linkedList.size() > 0) return linkedList.remove(0);
        throw new NoSuchElementException("no such element");
    }

    public Item poll() {
        if (linkedList.size() > 0) {
            return remove();
        }
        return null;
    }

    public Item element() {
        if (linkedList.size() > 0) return linkedList.get(0);
        throw new NoSuchElementException("no such element");
    }

    public Item peek() {
        if (linkedList.size() > 0) return linkedList.get(0);
        return null;
    }

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }
}
