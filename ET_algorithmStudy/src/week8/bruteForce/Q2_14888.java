// [백준] 연산자 끼워넣기
// https://www.acmicpc.net/problem/14888

package week8.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_14888 {
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int idx) {
        if(idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;

                switch(i) {
                    case 0:
                        dfs(num + numbers[idx], idx+1);
                        break;
                    case 1:
                        dfs(num - numbers[idx], idx+1);
                        break;
                    case 2:
                        dfs(num * numbers[idx], idx+1);
                        break;
                    case 3:
                        dfs(num / numbers[idx], idx+1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
