// [프로그래머스] 문자열 내 p와 y의 개수
// https://programmers.co.kr/learn/courses/30/lessons/12916

package algorithm1;

public class Q5_12916 {
    static boolean solution(String s) {
        s = s.toLowerCase();
        char[] s1 = s.toCharArray();

        int pcnt = 0;
        int ycnt = 0;
        for(char item : s1){
            if(item == 'p'){
                pcnt++;
            }
            else if(item == 'y'){
                ycnt++;
            }
        }
        return pcnt==ycnt;
    }
}
