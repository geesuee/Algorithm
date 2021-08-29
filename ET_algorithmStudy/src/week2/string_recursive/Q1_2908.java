// [백준] 상수
// https://www.acmicpc.net/problem/2908

package week2.string_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");

        String a = s1[0];
        String b = s1[1];

        int c = (a.charAt(2)-'0')*100 + (a.charAt(1)-'0')*10 + (a.charAt(0)-'0');
        int d = (b.charAt(2)-'0')*100 + (b.charAt(1)-'0')*10 + (b.charAt(0)-'0');

        if (c > d) {
            System.out.println(c);
        }
        else {
            System.out.println(d);
        }
    }
}
