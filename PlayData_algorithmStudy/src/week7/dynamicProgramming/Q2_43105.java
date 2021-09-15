// [프로그래머스] 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105

package week7.dynamicProgramming;

public class Q2_43105 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println("top-down 풀이 : " + solution1(triangle));
        System.out.println("bottom-up 풀이 : " + solution2(triangle));
    }

    //top-down
    public static int solution1(int[][] triangle) {
        // 1. 기본값 초기화  //
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        // 2. 동적계획법 //
        for(int i = 2; i < triangle.length; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        // 3. 최대값 반환 //
        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[dp.length - 1][i]);
        }

        return max;
    }

    //bottom-up
    public static int solution2(int[][] triangle) {
        for(int i = triangle.length-2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];
    }
}
