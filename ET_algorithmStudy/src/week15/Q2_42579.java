// [프로그래머스] 베스트앨범
// https://programmers.co.kr/learn/courses/30/lessons/42579
// 미완

package week15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q2_42579 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

        int[] answer = {};
        HashMap<String, List<Integer>> hashmap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            hashmap.put(genres[i], hashmap.getOrDefault(genres[i], new LinkedList<Integer>()));
            hashmap.get(genres[i]).add(plays[i]);
        }

        return answer;
    }
}
