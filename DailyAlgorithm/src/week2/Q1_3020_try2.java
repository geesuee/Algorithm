// [백준] 개똥벌레
// https://www.acmicpc.net/problem/3020

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1_3020_try2 {
    static ArrayList[] cave; // 동굴

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 길이
        int H = Integer.parseInt(st.nextToken()); // 높이

        cave = new ArrayList[H];
        for (int i = 0; i < H; i++) {
            cave[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            if (i % 2 != 0) { // 석순(홀수)
                for (int j = 0; j < size; j++) {
                    cave[j].add(1);
                }
            } else { // 종유석(짝수)
                for (int j = 0; j < size; j++) {
                    cave[H - (j+1)].add(1);
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        int[] sumArr = new int[cave.length];
        for (int i = 0; i < cave.length; i++) {
            sumArr[i] = cave[i].size();
            if (sumArr[i] < minSum) {
                minSum = sumArr[i];
            }
        }

        int cnt = 0;
        for (int i : sumArr) {
            if (i == minSum) {
                cnt += 1;
            }
        }

        System.out.println(minSum + " " + cnt);
    }
}
