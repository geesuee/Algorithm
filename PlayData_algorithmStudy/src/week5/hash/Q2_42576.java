// [프로그래머스] 완주하지 못한 선수
// https://programmers.co.kr/learn/courses/30/lessons/42576

package week5.hash;

import java.util.HashMap;

public class Q2_42576 {
    static String solution(String[] participant, String[] completion) {
        String answer ="";

        HashMap<String, Integer> map = new HashMap<>();

        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}
