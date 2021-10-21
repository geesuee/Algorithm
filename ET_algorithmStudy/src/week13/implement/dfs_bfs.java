package week13.implement;

import java.util.LinkedList;
import java.util.Queue;

public class dfs_bfs {
    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) {
        int n = 5;
        visit = new boolean[n];
        map = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 1, 1}};

        // 1 1 1 1 1
        // 1 1 0 1 1
        // 1 0 1 0 1
        // 1 1 0 1 1
        // 1 1 1 1 1

        System.out.print("DFS : " + 1 + " "); //dfs는 재귀로 돌기 때문에 출발 노드를 미리 출력^^
        dfs(1); //DFS : 1 0 2 4 3
        System.out.println();

        visit = new boolean[n];
        bfs(1); //BFS : 1 0 3 4 2
    }

    // DFS : 깊이 우선 탐색
    // 재귀로 구현
    static void dfs(int start) {
        visit[start] = true;
        for(int i = 0; i < map.length; i++) {
            if(map[start][i] == 1 && !visit[i]) {
                System.out.print(i + " ");
                dfs(i);
            }
        }
    }

    // BFS : 너비 우선 탐색
    // 큐로 구현
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;
        System.out.print("BFS : " + start + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i = 0; i < map.length; i++) {
                if(map[temp][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}



