// [프로그래머스] 여행경로
// https://programmers.co.kr/learn/courses/30/lessons/43164

package week13.Advanced;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4_43164 {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] answer = solution(tickets);
        for(String a : answer) {
            System.out.print(a + " ");
        }
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        String start = "ICN";
        PriorityQueue<String> canGo = new PriorityQueue<>();
        answer[0] = start;

        // 이동 횟수에 대한 큰 반복
        for(int i = 0; i < tickets.length; i++) {
            // 어디로 이동할 수 있는지 작은 반복
            for(String[] t : tickets) {
                if(t[0].equals(start)) {
                    canGo.add(t[1]);
                }
            }

            start = canGo.poll();  // 알파벳순 가장 앞 공항 뽑아 이동
            answer[i+1] = start;
            canGo.clear();  // 다음 이동 공항 탐색 전 canGo 초기화
            Arrays.stream(tickets).anyMatch()//미완
        }

        return answer;
    }
}
