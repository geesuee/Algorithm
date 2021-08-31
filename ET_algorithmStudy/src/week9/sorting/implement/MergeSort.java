// 병합 정렬 구현 연습
// 코드 출처 : https://url.kr/5h9r2n

package week9.sorting.implement;

public class MergeSort {
    public static int[] src;
    public static int[] tmp;

    public static void main(String[] args) {
        src = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 8};     // 정렬해야하는 배열
        tmp = new int[src.length];                      // 정렬한 값을 임시로 담아두는 배열

        printArray(src);
        mergeSort(0, src.length - 1);   // end 지점의 원소까지 검사하기 때문에 -1 해서 index 맞춰줌
        printArray(src);
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

    public static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
