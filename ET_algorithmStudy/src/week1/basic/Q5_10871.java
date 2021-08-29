// [백준] X보다 작은 수
// https://www.acmicpc.net/problem/10871

package week1.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] s1 = s.split(" ");

        int N = Integer.parseInt(s1[0]);
        int X = Integer.parseInt(s1[1]);

        String ss = br.readLine();
        String[] s2 = ss.split(" ");
        br.close();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(s2[i]);
            if (a < X) {
                System.out.print(a + " ");
            }
        }
    }
}
