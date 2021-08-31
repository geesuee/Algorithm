// 퀵 정렬 구현 연습
// 코드 출처 : https://st-lab.tistory.com/250

package week9.sorting.implement;

public class QuickSort {

    public static void sort(int[] a) {
        left_pivot_sort(a, 0, a.length - 1);
    }

    /**
     * 왼쪽 피벗 선택 방식
     * @param a     정렬할 배열
     * @param lo    현재 부분 배열의 왼쪽
     * @param hi    현재 부분 배열의 오른쪽
     */

    private static void left_pivot_sort(int[] a, int lo, int hi) {

        /*
         * lo가 hi보다 크거나 같다면
         * 정렬 할 원소가 1개 이하이므로 정렬하지 않고 return 한다.
         */
        if(lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        left_pivot_sort(a, lo, pivot - 1);
        left_pivot_sort(a, pivot + 1, hi);
    }

    /**
     * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
     *
     * @param a     정렬할 배열
     * @param left  현재 배열의 가장 왼쪽 부분
     * @param right 현재 배열의 가장 오른쪽 부분
     * @return      최종적으로 위치한 피벗의 위치(lo) 반환
     */
    private static int partition(int[] a, int left, int right) {

        int lo = left;
        int hi = right;
        int pivot = a[left];    // 부분 배열의 가장 왼쪽 요소를 피벗으로 설정

        // lo가 hi보다 작을 때 까지만 반복
        while(lo < hi) {

            /*
             * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
             * 찾을 때 까지 hi 감소
             */
            while(a[hi] > pivot && lo < hi) {
                hi--;
            }

            /*
             * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
             * 찾을 때 까지 lo 증가
             */
            while(a[lo] <= pivot && lo < hi) {
                lo++;
            }

            // 교환될 두 요소를 찾았으면 두 요소 swap
            swap(a, lo, hi);
        }

        /*
         * 마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와
         * lo가 가리키는 원소를 swap
         */
        swap(a, left, lo);

        // 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 lo 반환
        return lo;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
