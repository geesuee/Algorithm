// [프로그래머스] 소수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/42839

package week2.search;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Q2_42839 {
    TreeSet<String> set = new TreeSet<>();  // HashSet과 다르게 정렬해주는 Set => 검색이 빠름
    int count;

    public int solution(String numbers) {
        // numbers의 값 하나씩 쪼개서 ArrayList에 담기
        int size = numbers.length();
        List<Character> nums = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            nums.add(numbers.charAt(i));
        }

        // 결과를 저장할 ArrayLIst
        List<Character> result = new ArrayList<>();

        // 만들 수 있는 수 경우의 수 nPr로 계산
        // nPr에서 r의 값 1~n까지 늘려가면서 순열 알고리즘 수행
        for(int i = 0; i < size; i++) {
            permutation(nums, result, size, i + 1);
        }
        return count;
    }

    // 소수 판별 알고리즘
    public boolean isPrime(int n) {
        int sqrt = (int)Math.sqrt(n);

        // 2는 유일한 짝수 소수
        if(n == 2) { return true; }
        // 2 외의 짝수와 1은 소수가 아님
        else if(n % 2 == 0 || n == 1) { return false; }
        // n의 제곱근까지만 홀수로 나누어 확인하면 소수 판별 가능 = 에라토스테네스의 체
        // 3으로 나눠 3의 배수인지 확인, 5로 나누어 5의 배수인지 확인, ...
        for(int i = 3; i <= sqrt; i += 2) {
            if(n % i == 0) { return false; }
        }

        // 위의 경우에서 걸러지지 않은 수들은 다 소수
        return true;
    }

    // 순열 알고리즘 nPr
    public void permutation(List<Character> nums, List<Character> result, int n, int r) {

        if(r == 0) {  // 재귀 탈출 조건 명시
            // 0으로 시작하는 부분집합은 제외
            if (result.get(0) != '0') {
                String str = "";
                int size = result.size();
                for(int i = 0; i < size; i++) {
                    str += result.get(i);
                }
                int num = 0;

                // 이미 나온 숫자 조합이 아닐 경우(set에 없을 경우) set에 추가
                if(!set.contains(str)) {
                    num = Integer.parseInt(str);
                    set.add(str);

                    // 소수 판별, 소수라면 count++;
                    if(isPrime(num)) {
                        count++;
                    }
                }
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            result.add(nums.remove(i));
            permutation(nums, result, n-1, r-1);
            nums.add(i, result.remove(result.size() - 1));
        }
    }
}
