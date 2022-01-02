// [백준] 13458 시험 감독
// https://www.acmicpc.net/problem/13458

package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_13458 {
    static int N;           // 시험장의 개수
    static int B;           // 총감독관이 감시할 수 있는 응시자의 수
    static int C;           // 부감독관이 감시할 수 있는 응시자의 수
    static int[] examinee;  // 각 시험장별 응시자 수

    // 각 시험장에 총감독관은 오직 1명, 부감독관은 여러 명 있어도 됨
    // ** 총감독관만으로 모든 응시자를 감시할 수 있는 경우 처리 필요!!
    // ** N = 1,000,000 이고 각 시험장별 응시자 수도 1,000,000 명인 상황에서 B = 1, C = 1 이면, 필요한 최소 감독관 수는 1,000,000 * 1,000,000 이므로 long 타입으로 선언 필요!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        examinee = new int[N];
        for (int i = 0; i < N; i++) {
            examinee[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(countSupervisor());
    }

    static long countSupervisor() {
        long supervisor = N;

        for (int i = 0; i < examinee.length; i++) {
            examinee[i] = examinee[i] - B;

            if (examinee[i] > 0) {
                supervisor += (long) Math.ceil(examinee[i] / (double)C);
            }
        }

        return supervisor;
    }
}
