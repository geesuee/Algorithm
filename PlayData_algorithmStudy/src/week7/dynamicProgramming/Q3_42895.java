// [프로그래머스] N으로 표현
// https://programmers.co.kr/learn/courses/30/lessons/42895

package week7.dynamicProgramming;

public class Q3_42895 {
    static int answer= -1;

    public static void main(String[] args) {
        int answer=solution(5,12);
        System.out.println(answer);
    }

    public static int solution(int N, int number) {
        logic(N,number,0,0);
        return answer;
    }

    //n=5/number=12/count=0/calc=0
    //55
    public static void logic(int n,int number,int count,int calc) {
        int nn=n;

        if(calc==number) {
            if(answer>count || answer == -1) {
                answer=count;
                return;
            }
        }

        //dfs를 통해 사칙연산 깊이마다 수행.
        //ex ) 2,11 입력받을 시 2,count=1 로 시작해서 count=9 일 때 까지 덧셈만 연산 후
        // 마지막 9의 뎁스에서 모든 2에 관한 덧셈 연산 수행 후 하위 뎁스로 넘어가
        //22로 변경하여 다음 for문으로 인해 사칙연산을 수행이 가능한 뎁스에서
        // 중복된 값의  사칙연산 수행
        //5 dfs
        //5 => 55
        //55+5/5*5
        //5+5 i==1
        //5+55 i==2
        //5+555 i==3 5+55+55+5*555...
        for(int i=1;i<9-count;i++) {
            logic(n,number,count+i,nn+calc);
            logic(n,number,count+i,nn*calc);
            logic(n,number,count+i,nn-calc);
            logic(n,number,count+i,calc/nn);
            nn=nn*10+n;
        }
    }
}
