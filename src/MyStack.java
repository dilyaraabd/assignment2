public class MyStack<Item extends Comparable<? super Item>> {
    private MyLinkedList<Item> linkedList;

    public MyStack() {
        linkedList = new MyLinkedList<>();
    }

    public Item push(Item item) {
        linkedList.add(item);
        return item;
    }

    public Item pop() {
        int lastItem = linkedList.size() - 1;
        return linkedList.remove((int) lastItem);
    }

    public Item peek() {
        int lastItem = linkedList.size() - 1;
        return linkedList.get(lastItem);
    }

    public int search(Item item) {
        return linkedList.size() - 1 - linkedList.lastIndexOf(item);
    }

    public boolean empty() {
        return linkedList.size() == 0;
    }
}
