// [백준] 소트인사이드
// https://www.acmicpc.net/problem/1427
// 병합 정렬 구현 풀이

package week9.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_1427_implement {
    public static int[] src;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        src = new int[arr.length];
        tmp = new int[src.length];

        for(int i = 0; i < arr.length; i++) {
            src[i] = arr[i] - '0';
        }

        mergeSort(0, src.length - 1);

        for(int j = src.length -1; j >=0; j--) {
            System.out.print(src[j]);
        }
    }

    public static void mergeSort(int start, int end) {
        if(start < end) {
            int mid = (start+end) / 2;

            // 재귀로 반복 분할
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            int p = start;      // 분할된 부분 집합의 첫번째 원소 인덱스
            int q = mid + 1;    // 분할된 부분 집합의 첫번째 원소 인덱스
            int idx = p;

            // 동시에 종료되지 않을 수 있으니 || 조건
            // =이 들어간 것은 원소의 개수가 1개일 때까지 쪼개기 때문
            while(p <= mid || q <= end) {
                if(q > end || (p <= mid && src[p] <= src[q])) {
                    tmp[idx++] = src[p++];  // 1번 분할의 값
                }else {
                    tmp[idx++] = src[q++];  // 2번 분할의 값
                }
            }

            for(int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }
}
