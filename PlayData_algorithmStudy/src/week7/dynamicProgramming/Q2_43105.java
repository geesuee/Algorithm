// [프로그래머스] 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105

package week7.dynamicProgramming;

public class Q2_43105 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        solution(triangle);
    }

    public static int solution(int[][] triangle) {
        int[] DP = new int[triangle.length + 1];

        DP[1] = triangle[0][0];
        DP[2] = triangle[0][0] + Math.max(triangle[1][0], triangle[1][1]);

        //자기 바로 밑에 두 개 중 큰 것 체크하는 로직
        
        //다음 레벨로 넘어간 부분까지 비교하는 로직

        int answer = 0;
        return answer;
    }
}
