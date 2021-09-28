// [백준] 특정 거리의 도시 찾기
// https://www.acmicpc.net/problem/18352

// StringBuilder로 출력
// 메모리 초과

package week8.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2_18352_trial {
    static int N;
    static int M;
    static int K;
    static int X;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        br.close();

        System.out.println(dijkstra(X, K));

//        Runtime.getRuntime().gc();
//        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.print(usedMemory + " bytes");

//        for(int[] m : map) {
//            for(int a : m) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }
    }

    public static String dijkstra(int X, int K) {
        int cost[] = new int[N+1]; // 비용 저장 배열
        boolean[] visited = new boolean[N+1]; // 방문 여부 저장 배열

        // cost 값 초기화(최대값으로)
        for(int i = 1; i < N+1; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        // 시작 노드 값 초기화
        cost[X] = Integer.MAX_VALUE;
        visited[X] = true;

        // 연결된 노드 cost 값 갱신
        List<Integer> linked_index = new ArrayList<>();
        for(int i = 1; i < N+1; i++) {
            if(!visited[i] && map[X][i] == 1) {
                cost[i] = 1;
                linked_index.add(i);
            }
        }

        // 최소 cost 값 갱신
        for(int idx : linked_index) {
            visited[idx] = true;

            for(int i = 1; i < N+1; i++) {
                if(!visited[i] && map[idx][i] == 1) {
                    if(cost[i] > cost[idx] + map[idx][i]) {
                        cost[i] = cost[idx] + map[idx][i];
                    }
                }
            }
        }

        // 결과값 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N+1; i++) {
            if(cost[i] == K) {
                sb.append(i + "\n");
            }
        }

        return sb.length()!=0? sb.toString():"-1";
    }
}
