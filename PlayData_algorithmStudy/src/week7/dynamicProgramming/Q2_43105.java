// [프로그래머스] 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105

package week7.dynamicProgramming;

public class Q2_43105 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        solution(triangle);
    }

    public static int solution(int[][] triangle) {
        int[][] DP = new int[triangle.length][triangle.length];

        DP[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            DP[i][0] = triangle[i][0] + DP[i-1][0];

            for(int j = 1; j < i+1; j++) {
                DP[i][j] = triangle[i][j] + Math.max(DP[i -1][j - 1], DP[i -1][j]);
            }
        }

        int max = 0;
        for(int i = 0; i < DP[DP.length - 1].length; i++) {
            max = Math.max(DP[DP.length - 1][i], max);
        }

        return max;
    }
}
