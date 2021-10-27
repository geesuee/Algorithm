// [프로그래머스] 조이스틱
// https://programmers.co.kr/learn/courses/30/lessons/42860

package week13.Basic;

public class Q1_42860 {

    public static void main(String[] args) {
        String name = "AABA";
        // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

        System.out.println(solution(name));
    }

    public static int solution(String name) {

        int count = 0;
        int length = name.length();
        int minCnt = length - 1; //좌우 이동 최대값
        for(int i = 0; i < length; i++) {
            char c = name.charAt(i);
            count += Math.min(c - 'A', 'Z' - c + 1);

            int next_idx = i + 1;
            while(next_idx < length && name.charAt(next_idx) == 'A') {
                next_idx++;
            }
            minCnt = Math.min(minCnt, 2 * i + (length - next_idx));
        }
        count += minCnt;

        return count;
    }
}
