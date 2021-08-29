// [백준] 수강신청
// https://www.acmicpc.net/problem/13414

package week6.map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Q1_13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++) {
            String number = br.readLine();
            set.remove(number);
            set.add(number);
        }

        Iterator<String> iter = set.iterator();
        int cnt = 0;
        while(iter.hasNext() && cnt < K) {
            System.out.println(iter.next());
            cnt++;
        }
    }
}
