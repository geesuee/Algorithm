// [백준] 유기농 배추
// https://www.acmicpc.net/problem/1012
// 미완

package week15.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1_1012 {
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for(int i = 0; i < T; i++) { // 테스트 케이스 반복
            int larva = 0;

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            int size = Math.max(M,N);
            arr = new int[size][size];
            visit = new boolean[M*N];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
                arr[Y][X] = 1;
            }

            // 핵심 로직 실행
            for(int k = 0; k < visit.length; k++) {
                if(!visit[i]) {
                    bfs(i, visit, arr);
                    larva++;
                }
            }

            sb.append(larva).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static void bfs(int i, boolean[] visit, int[][] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int j = 0; j < arr.length; j++) {
                if(arr[temp][j] == 1 && !visit[j]) {
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
