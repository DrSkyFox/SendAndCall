
public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------LinkedList-----------------------------");
        MyLinkedList();
        System.out.println("-----------------------------Array-----------------------------");
        //myArray();

    }

    private static void MyLinkedList() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.removeElementByIndex(2);
        System.out.println(list);

        System.out.println("Remove first");

        IMyLinkedList llist  = (IMyLinkedList) list;
        llist.removeFirst();
        System.out.println(llist);
        llist.removeLast();
        System.out.println(llist);
    }

    private static void myArray() {
        MyList<Integer> list = new MyArrayList<>();
        System.out.println(list);

        list.add(10);
        list.add(5);
        System.out.println(list);

        for (int i = 0; i < 11; i++) {
            list.add(i);
            System.out.println(list);
        }

        System.out.println("3 element:" +  list.get(3));
        list.removeElementByIndex(4);
        System.out.println(list);

        list.addAfterIndex(3, 996);
        System.out.println(list);


    }
}
