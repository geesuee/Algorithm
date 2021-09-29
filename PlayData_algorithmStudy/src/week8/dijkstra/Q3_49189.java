// [프로그래머스] 가장 먼 노드
// https://programmers.co.kr/learn/courses/30/lessons/49189

package week8.dijkstra;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_49189 {

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge){
        boolean[] check = new boolean[n];
        boolean[][] connect = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<edge.length; i++){
            connect[edge[i][0]-1][edge[i][1]-1]=true;
            connect[edge[i][1]-1][edge[i][0]-1]=true;
        }

//        for(boolean[] e : connect) {
//            for(boolean i : e) {
//                System.out.print(i==true? "T ":"F ");
//            }
//            System.out.println();
//        }

        check[0]=true;
        q.add(0);

        int answer = 0;

        //가중치가 없는 그래프의 최소거리를 보장해주는 탐색법 BFS
        //가장 멀리 떨어져있는 노드는 가장 마지막 큐의 사이즈와 같음
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int node = q.poll(); //큐에서 빼서 해당 노드에 연결된 노드 확인
                for(int j = 0; j < n; j++){
                    if(connect[j][node] && !check[j]){ //연결이 되어있고, 방문하지 않았다면
                        check[j]=true; //방문하고
                        q.add(j); //큐에 넣어줌
                    }
                }
            }
            answer = qSize;
        }
        return answer;
    }
}
