public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5, 1);
        list.sort();
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.contains(5));
        System.out.println(list.remove((Integer) 5));
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.lastIndexOf(5));
        list.clear();
        MyList<Integer> secondList = new MyLinkedList<>();
        secondList.add(1);
        secondList.add(3);
        secondList.add(2);
        secondList.add(5, 1);
        secondList.sort();
        for (int i=0; i<secondList.size(); i++) {
            System.out.println(secondList.get(i));
        }
        System.out.println(secondList.contains(5));
        System.out.println(secondList.remove((Integer) 5));
        for (int i=0; i<secondList.size(); i++) {
            System.out.println(secondList.get(i));
        }
        System.out.println(secondList.lastIndexOf(5));
        secondList.clear();
    }
}
