// [프로그래머스] 기능개발
// https://programmers.co.kr/learn/courses/30/lessons/42586

package week1.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_42586 {
    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }

        LinkedList<Integer> counts = new LinkedList<>();
        int cnt = 1;
        int front = queue.poll();

        while(!queue.isEmpty()) {
            int next = queue.poll();

            if(front < next) {  // 앞의 값이 뒤의 값보다 작으면 바로 끝, 다시 loop
                counts.add(cnt);
                cnt = 1;
                front = next;
                continue;
            }
            else {
                cnt++;
            }
        }
        counts.add(cnt);
        int[] answer = new int[counts.size()];

        for(int i = 0; i < counts.size(); i++) {
            answer[i] = counts.get(i);
        }

        return answer;
    }
}
