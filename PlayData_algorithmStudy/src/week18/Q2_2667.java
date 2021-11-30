// [백준] 단지번호붙이기
// https://www.acmicpc.net/problem/2667

package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2_2667 {
    static int N, unit;
    static int[][] arr;
    static boolean[][] visited;
    static int[] unitSize;

    // 좌 우 상 하
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // bfs를 돌고
            // 돌면서 사이즈 체크하여 int[] unitSize 에 저장
        // bfs가 끝나면 unit++;
        // unit과 사이즈 오름차순으로 출력

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        // System.out.println(Arrays.deepToString(map));

        unit = 0;
        unitSize = new int[25*25];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    unit++;
                }
            }
        }

        sb.append(unit).append("\n");
        Arrays.sort(unitSize);
        for (int u : unitSize) {
            if(u != 0) {
                sb.append(u).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        unitSize[unit]++;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            // 사방 체크
            for (int k = 0; k < 4; k++) {
                int newR = temp[0] + dx[k];
                int newC = temp[1] + dy[k];

                if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                    if (arr[newR][newC] == 1 && !visited[newR][newC]) {
                        queue.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                        unitSize[unit]++;
                    }
                }
            }
        }
    }
}
