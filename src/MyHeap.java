public class MyHeap<Item extends Comparable<? super Item>> {

    private MyArrayList<Item> arrayList;

    private static final int FRONT = 1;

    public MyHeap() {
        arrayList = new MyArrayList<>();
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos > (arrayList.size() / 2) && pos <= arrayList.size();
    }

    private void swap(int fpos, int spos) {
        Item ftmp = arrayList.remove(fpos);
        arrayList.add(arrayList.get(spos), fpos);
        Item stmp = arrayList.remove((int) spos);
        arrayList.add(ftmp, spos);
    }

    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            if (arrayList.get(pos).compareTo(arrayList.get(leftChild(pos))) > 0 || arrayList.get(pos).compareTo(arrayList.get(rightChild(pos))) > 0) {
                if (arrayList.get(leftChild(pos)).compareTo(arrayList.get(rightChild(pos))) < 0) {
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(Item item) {
        int beforeSize = arrayList.size();
        arrayList.add(item);
        while (arrayList.get(beforeSize).compareTo(arrayList.get(parent(beforeSize))) < 0) {
            swap(beforeSize, parent(beforeSize));
            beforeSize = parent(beforeSize);
        }
    }

    public void print() {
        for (int i = 0; i <= arrayList.size() / 2; i++) {
            System.out.print(
                    " PARENT : " + arrayList.get(i)
                            + " LEFT CHILD : " + arrayList.get(leftChild(i))
                            + " RIGHT CHILD :" + arrayList.get(rightChild(i)));

            System.out.println();
        }
    }

    public Item removeRoot() {
        Item result = arrayList.get(0);
        arrayList.remove((int) 0);
        heapify(0);
        return result;
    }

    public boolean remove(Item item) {
        boolean result = arrayList.remove(item);
        heapify(0);
        return result;
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");

        MyHeap<Integer> minHeap = new MyHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        System.out.println("The Min val is " + minHeap.removeRoot());
        minHeap.print();
    }
}
