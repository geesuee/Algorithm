// [프로그래머스] 주식가격
// https://programmers.co.kr/learn/courses/30/lessons/42584

package week1.stack_queue;

public class Q1_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    break;
                } else {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
