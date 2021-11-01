// [프로그래머스] H-Index
// https://programmers.co.kr/learn/courses/30/lessons/42747

package week14.Basic;

import java.util.Arrays;

public class Q2_42747 {

    public static void main(String[] args) {
        int[] citations = {0, 0, 1};

        System.out.println("answer: " + solution(citations));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int h = 0;
        for(int i = 0; i <= citations[citations.length-1]; i++) {
//            System.out.println("현재 i : " + i);
            for(int j = 0; j < citations.length; j++) {
                if(i <= citations[j]) {
//                    System.out.println("i: " + i + " / j: " + j);
//                    System.out.println("남은 논문 수 : " + (citations.length-j));
                    if(i <= citations.length-j) {
                        h = i;
//                        System.out.println("h: " + h);
                    }
                    break;
                }
            }
        }

        return h;
    }
}
