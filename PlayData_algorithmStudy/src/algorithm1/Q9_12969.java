// [프로그래머스] 직사각형 별찍기
// https://programmers.co.kr/learn/courses/30/lessons/12969

package algorithm1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Q9_12969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
    }
}
