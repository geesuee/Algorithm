// [프로그래머스] 카펫
// https://programmers.co.kr/learn/courses/30/lessons/42842

package week15.Basic;

import java.util.Arrays;

public class Q2_42842 {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;

        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        // 중앙에는 노란색으로 칠해져 있고 테두리 **1줄**은 갈색으로 칠해져 있는
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
        // 카펫 가로 길이 - 2 = 노랑의 가로 길이
        // 카펫 세로 길이 - 2 = 노랑의 세로 길이
        // (카펫 가로 길이 - 2) * (카펫 세로 길이 - 2) = yellow

        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 1; i <= total; i++) {
            // 가로 : x, 세로 : i
            int x = total / i;

            // 세로가 더 길면 넘어가기
            if(i > x) {
                continue;
            }

            if((x-2) * (i -2) == yellow) {
                answer[0] = x;
                answer[1] = i;
                return answer; //이게 꼭 있어야 하는데..?
            }
        }

        return answer;
    }
}
