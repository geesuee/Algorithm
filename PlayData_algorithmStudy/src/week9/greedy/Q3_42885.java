// [프로그래머스] 구명보트
// https://programmers.co.kr/learn/courses/30/lessons/42885

package week9.greedy;

import java.util.Arrays;

public class Q3_42885 {

    public static void main(String[] args) {
        int[] people = {100,500,500,900,950}; //500,500/100,900/950
        int limit = 1000;

        System.out.println(solution(people,limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int p1 = 0;

        for(int p2 = people.length-1; p2 >= p1; p2--) {
            if(people[p1] + people[p2] > limit) {
            }else {
                p1++;
            }
            answer++;
        }

        return answer;
    }
}
