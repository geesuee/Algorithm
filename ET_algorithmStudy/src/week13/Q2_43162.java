// [프로그래머스] 네트워크
// https://programmers.co.kr/learn/courses/30/lessons/43162

package week13;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_43162 {

    public static void main(String[] args) {
        int n = 3;
        //int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        // 1 1 0
        // 1 1 0
        // 0 0 1
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i, visit, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void bfs(int i, boolean[] visit, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            // System.out.print(temp + " ");
            for(int j = 1; j < computers.length; j++) {
                if(computers[temp][j] == 1 && !visit[j]) {
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
