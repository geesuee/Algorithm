// [백준] 소트인사이드
// https://www.acmicpc.net/problem/1427

package week9.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        for(char c : arr) {
            sb.append(c);
        }

        System.out.println(sb.reverse());
    }
}
