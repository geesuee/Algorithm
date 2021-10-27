// [프로그래머스] 징검다리
// https://programmers.co.kr/learn/courses/30/lessons/43236
// 미완

package week13.Advanced;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q3_43236 {

    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        solution(distance, rocks, n);
    }

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        List<Integer> dist = new LinkedList<>();

        for(int i = 0; i < rocks.length; i++) {
            if(i == 0) {
                dist.add(rocks[i]-1);
            } else if(i == rocks.length-1) {
                dist.add(rocks[i]-rocks[i-1]);
                dist.add(distance-rocks[i]);
            } else {
                dist.add(rocks[i]-rocks[i-1]);
            }
        }

        for(int d : dist) {
            System.out.print(d + " ");
        }

        int answer = 0;
        return answer;
    }
}
