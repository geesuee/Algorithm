// [프로그래머스] 더맵게
// https://programmers.co.kr/learn/courses/30/lessons/42626

package week10.linkedList;

import java.util.PriorityQueue;

public class Q2_42626 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {

        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for(int s : scoville) {
            foods.add(s);
        }

        int cnt = 0;

        while(foods.peek() < K) {
            int f1 = foods.poll();
            int f2 = foods.poll();
            int newFood = f1 + (f2 * 2);

            if(foods.isEmpty() && newFood < K) {
                return -1;
            }

            foods.add(newFood);
            cnt++;
        }

        return cnt;
    }
}
