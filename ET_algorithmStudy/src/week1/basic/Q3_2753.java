// [백준] 윤년
// https://www.acmicpc.net/problem/2753

package week1.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_2753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int year = Integer.parseInt(s);
        br.close();

        if (((year % 4 == 0) & (year % 100 != 0)) | (year % 400 == 0)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
