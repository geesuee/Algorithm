// [백준] 나머지
// https://www.acmicpc.net/problem/10430

package week1.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_10430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println((A+B) % C);
        System.out.println(((A%C) + (B%C)) % C);
        System.out.println((A*B) % C);
        System.out.println(((A%C) * (B%C)) % C);
    }
}
