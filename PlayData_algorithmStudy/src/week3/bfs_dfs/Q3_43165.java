// [프로그래머스] 타겟 넘버
// https://programmers.co.kr/learn/courses/30/lessons/43165

package week3.bfs_dfs;

public class Q3_43165 {
    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int depth, int sum) {
        int matchCount = 0;

        // 재귀 탈출 조건
        if (depth == numbers.length) {
            if (sum == target) {  // 만들어낸 조합의 합이 target과 같아지면 1 return. 아래 matchCount에 누적
                return 1;
            }
            return 0;
        }

        matchCount += dfs(numbers, target, depth + 1, sum + numbers[depth]);  // sum에 하나씩 뽑아 더하기
        matchCount += dfs(numbers, target, depth + 1, sum - numbers[depth]);  // sum에 하나씩 뽑아 빼기
        return matchCount;
    }
}
