// queue 라이브러리 활용

package week3.stack_queue_dequeue.implement;

import java.util.LinkedList;
import java.util.Queue;

public class Practice_queue {

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();  // int 형 queue1 선언, linkedlist 이용
        Queue<String> queue2 = new LinkedList<>();  // String 형 queue2 선언, linkedlist 이용

        // 큐에 값 추가
        queue1.add(1);
        queue1.add(2);
        queue1.offer(3);

        // 큐 값 삭제
        queue1.poll();  // queue 의 첫번째 값을 반환하고 제거, 비어있다면 null
        queue1.remove();  // queue 의 첫번째 값 제거
        queue1.clear();   // queue 초기화

        // 큐에서 가장 먼저 들어간 값 출력
        queue2.add("HI");
        queue2.add("HELLO");

        queue2.peek();
    }
}
