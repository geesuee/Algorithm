// [백준] 바이러스
// https://www.acmicpc.net/problem/2606

package week7.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1_2606 {
    static boolean[] visit;
    static ArrayList<Integer>[] arr;
    static int count = 0;
    static int C,L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer (br.readLine());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[C+1];
        arr = new ArrayList[C+1];
        for (int i = 1; i <= C; i++) {
            visit[i] = false;
            arr[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer (br.readLine());
        L = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= L; i++) { // 해당 노드에 연결된 애들만 넣어줌
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i = 0; i < arr[start].size(); i++) {
            int next = arr[start].get(i);
            if (!visit[next]) {  // 연결되어 있는 것들 중에 방문하지 않은 것 선별
                count += 1; // 감염된 수 ++
                dfs(next);
            }
        }
    }
}
