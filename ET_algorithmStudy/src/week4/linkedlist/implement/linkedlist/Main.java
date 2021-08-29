package week4.linkedlist.implement.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addFirst(30);
        numbers.addFirst(20);
        numbers.addFirst(10);

        numbers.removeFirst();

        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);

        System.out.println(numbers);
        numbers.add(2, 25);

        System.out.println(numbers);
        System.out.println(numbers.remove(3));
        System.out.println(numbers.removeLast());

        System.out.println(numbers);

        System.out.println(numbers.size());

        System.out.println(numbers.get(2));

        System.out.println(numbers.indexOf(5));
    }
}
