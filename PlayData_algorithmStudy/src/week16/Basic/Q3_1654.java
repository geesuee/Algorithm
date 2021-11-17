// [백준] 랜선 자르기
// https://www.acmicpc.net/problem/1654

package week16.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q3_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> length = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < K; i++) {
            int len = Integer.parseInt(br.readLine());
            length.add(len);
            max = Math.max(max, len);
        }

        long answer = 0;
        long start = 1;
        long end = max;
        while(start <= end) {
            long mid = (start+end)/2;
            if(canCut(length, N, mid)) {
                answer = Math.max(answer, mid);
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }

    public static boolean canCut(List<Integer> length, int N, long len) {
        int cut = 0;
        for(int i = 0; i < length.size(); i++) {
            cut += length.get(i)/len;
        }

        return cut >= N;
    }
}
