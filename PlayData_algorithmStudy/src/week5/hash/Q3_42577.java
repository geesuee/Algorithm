// [프로그래머스] 전화번호 목록
// https://programmers.co.kr/learn/courses/30/lessons/42577

package week5.hash;

import java.util.HashMap;

public class Q3_42577 {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        int num = 0;
        for(String phone : phoneBook) {
            map.put(phone, num++);
        }

        for(int i = 0; i < phoneBook.length; i++) {
            for(int j = 1; j < phoneBook[i].length(); j++) {
                if (map.containsKey(phoneBook[i].substring(0, j))) {  // substring은 0 ~ j-1까지 잘라주는 메소드
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
