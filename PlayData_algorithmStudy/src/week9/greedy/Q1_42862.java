// [프로그래머스] 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862

package week9.greedy;

import java.util.Arrays;

public class Q1_42862 {

    public static void main(String[] args) {
        int n = 3;
        int[] lost = {1,2};
        int[] reserve = {2,3};

        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;
        int llen = lost.length;
        int rlen = reserve.length;

        for(int i = 0; i < llen; i++) {
            for(int j = 0; j < rlen; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    //System.out.println(lost[i] + "학생 / 맞는걸로 / " + reserve[j] + " / " + answer);
                    reserve[j] = -100;
                    lost[i] = -100;
                    break;
                }
            }
        }

        for(int l : lost) {
            for(int i = 0; i < rlen; i++) {
                if(l == reserve[i]-1) {
                    answer += 1;
                    //System.out.println(l + "학생 / 작은걸로 / " + reserve[i] + " / " + answer);
                    reserve[i] = -1;
                    break;
                }else if(l == reserve[i]+1) {
                    answer += 1;
                    //System.out.println(l + "학생 / 큰걸로 / " + reserve[i] + " / " + answer);
                    reserve[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
