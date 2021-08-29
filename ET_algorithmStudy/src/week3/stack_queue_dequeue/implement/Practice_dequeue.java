// dequeue 라이브러리 활용

package week3.stack_queue_dequeue.implement;

import java.util.LinkedList;

public class Practice_dequeue {

    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();

        // 덱에 값 추가
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(6);
        deque.addLast(5);
        deque.addLast(4);

        System.out.println("size : " + deque.size());

        // 덱 양 끝 요소 반황
        System.out.println(deque.peek());  // peek = peekFirst
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        // 덱 양 끝 요소 없애면서 반환
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());

        // 덱 요소 전체 출력
        for(int i = 0; i < deque.size(); i++) {
            System.out.print(deque.poll() + " ");
        }
    }
}
