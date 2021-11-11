// [프로그래머스] 위장
// https://programmers.co.kr/learn/courses/30/lessons/42578

package week15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q1_42578 {

    public static void main(String[] args) {
//        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> hashmap = new HashMap<>();

        for(String[] c : clothes) {
//            hashmap.put(c[0], hashmap.getOrDefault(c[0], new LinkedList<>()).add(c[1]) );
            hashmap.put(c[1], hashmap.getOrDefault(c[1], new LinkedList<String>()));
            hashmap.get(c[1]).add(c[0]);
        }

        for(String k : hashmap.keySet()) {
//            System.out.println(k);
//            System.out.println(hashmap.get(k));
            answer *= hashmap.get(k).size() + 1;
        }

        return answer - 1;
    }
}
