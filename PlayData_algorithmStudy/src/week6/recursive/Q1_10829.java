// [백준] 이진수 변환
// https://www.acmicpc.net/problem/10829

package week6.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_10829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Long.toBinaryString(Long.parseLong(br.readLine())));
    }
}
