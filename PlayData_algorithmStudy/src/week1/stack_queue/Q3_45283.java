// [프로그래머스] 다리를 지나는 트럭
// https://programmers.co.kr/learn/courses/30/lessons/42583

package week1.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_45283 {
    static int queueSum(Queue<Integer> queue) {
        int sum = 0;
        for(int n : queue) {
            sum += n;
        }
        return sum;
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int size = queue.size();
        int answer = 0;
        int i = 0;

        for(int truck : truck_weights) {
            while(true) {
                if(queue.isEmpty()){
                    queue.add(truck);
                    answer++;
                    break;  // truck 값을 넣어주고 나서는 break
                } else if(queue.size() == bridge_length) {
                    queue.poll();
                } else {
                    if(queueSum(queue) + truck <= weight) {
                        queue.add(truck);
                        answer++;
                        break;  // truck 값을 넣어주고 나서는 break
                    } else {  // 무게가 초과되어 다음 truck 못 들어올 시
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;  // 마지막에 들어있는 값 다 빼서 큐를 비울 때 고려 + bridge_length
    }
}
