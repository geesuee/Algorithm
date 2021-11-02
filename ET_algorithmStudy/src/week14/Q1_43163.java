// [프로그래머스] 단어 변환
// https://docs.google.com/document/d/1LDX1ygZ1gf-GjSsnQ83wmFA7LGsoakK2InimdvlWEXw/edit

package week14;

public class Q1_43163 {
    static int answer;
    static boolean[] used;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    }

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        used = new boolean[words.length];

        dfs(begin, target, words,0);
        return answer == Integer.MAX_VALUE? 0 : answer;
    }

    public static void dfs(String cWord, String target, String[] words, int cnt) {

        // 재귀 탈출 조건
        if(cWord.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!used[i] && check(cWord, words[i])) {
                used[i] = true;
                dfs(words[i], target, words, cnt+1); // 이렇게 돌다보면 이전에 사용한 단어들은 다 used 가 true가 됨
                used[i] = false; // 한 세트 끝내고 i가 다음 걸로 넘어가면 다시 리셋해주어야 하니까 하나씩 다시 안 사용한 것으로 돌림
            }
        }
    }

    public static boolean check(String cWord, String nWord) {
        int diff = 0;
        for(int i = 0; i < cWord.length(); i++) {
            if(cWord.charAt(i) != nWord.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
