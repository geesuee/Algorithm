// [프로그래머스] 이중우선순위큐
// https://programmers.co.kr/learn/courses/30/lessons/42628
// 미완

package week10.linkedList;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q3_42628 {

    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(solution(operations)[0] + " / " +solution(operations)[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int cnt = 0;

        for(String s : operations) {
            String s1 = s.substring(0,1);
            String s2 = s.substring(2);

            if(priorityQueue.isEmpty() && cnt != 0) {
                answer = new int[]{0, 0};
                return answer;
            }
            if(s1.equals("I")) {
                priorityQueue.add(Integer.parseInt(s2));
            }else if(s1.equals("D")) {
                if(s2.equals("-1")) {
                    priorityQueue.poll();
                }else if(s2.equals("1")) {
                    PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
                    reverse.addAll(priorityQueue);
                    int out = reverse.poll();
                    System.out.println(out);
                    System.out.println(reverse.contains(653));
                    priorityQueue.addAll(reverse);
                }
            }
            cnt++;
        }

        if(priorityQueue.size() < 2) {
            answer = new int[] {0, 0};
            return answer;
        } else {
            answer[1] = priorityQueue.poll();
            PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
            reverse.addAll(priorityQueue);
            answer[0] = reverse.poll();
        }

        return answer;
    }
}
