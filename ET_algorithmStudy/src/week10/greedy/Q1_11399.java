// [백준] ATM
// https://www.acmicpc.net/problem/11399

package week10.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < time.length; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(greedySum(time));
    }

    static int greedySum(int[] time) {
        Arrays.sort(time);
        int sum = 0;
        for(int i = 0; i < time.length; i++) {
            sum += time[i] * (time.length - i);
        }

        return sum;
    }
}
