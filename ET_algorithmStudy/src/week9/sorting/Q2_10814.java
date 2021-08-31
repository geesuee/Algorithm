// [백준] 나이순 정렬
// https://www.acmicpc.net/problem/10814
// 미완

package week9.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());

        for(Map.Entry entry : list) {
            
        }
    }
}
