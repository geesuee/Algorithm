// [백준] 전자레인지
// https://www.acmicpc.net/problem/10162

package week9.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_10162 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        System.out.println(T%10 == 0? T/300 + " " + T/60 + " " + T/10 : -1);
    }
}
