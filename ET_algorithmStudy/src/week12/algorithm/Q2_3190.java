// [백준] 뱀
// https://www.acmicpc.net/problem/3190

// 아직 풀지 못함..!

package week12.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_3190 {
    static int N,K,L;
    static int[][] location;
    static String[][] direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //보드의 크기
        K = Integer.parseInt(br.readLine()); //사과의 개수

        location = new int[N][N]; //사과 위치
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            location[a][b] = 1;
        }

        L = Integer.parseInt(br.readLine()); //뱀의 방향 변환 횟수
        direction = new String[L][1];
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direction[i][0] = st.nextToken();
            direction[i][1] = st.nextToken();
        }

        Snake snake = new Snake(L);

        System.out.println(dummy());
    }

    public static class Snake {
        int length;
        int move;

        Snake(int L) {
            this.length = 1;
            this.move = L;
        }
    }

    static int dummy() {
        return 0;
    }
}
