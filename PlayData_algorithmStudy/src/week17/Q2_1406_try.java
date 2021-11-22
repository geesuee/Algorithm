// [백준] 에디터
// https://www.acmicpc.net/problem/1406
// 실패 : 시간 초과
// LinkedList를 사용했는데, 중간에 삽입/삭제가 빈번해서 시간 초과 발생

package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Q2_1406_try {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        int cursor = list.size();

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if(c == 'L') {
                if(cursor != 0) {
                    cursor--;
                }
            }else if(c == 'D') {
                if(cursor != list.size()) {
                    cursor++;
                }
            }else if(c == 'B') {
                if(cursor != 0) {
                    list.remove(cursor-1);
                    cursor--;
                }
            }else { // P
                list.add(cursor, command.charAt(2));
                cursor++;
            }
        }

        for(char c : list) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
