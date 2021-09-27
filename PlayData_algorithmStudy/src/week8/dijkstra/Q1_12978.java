// [프로그래머스] 배달
// https://programmers.co.kr/learn/courses/30/lessons/12978

package week8.dijkstra;

public class Q1_12978 {

    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        System.out.println(solution(N, road, K));
    }

    public static int solution(int N, int[][] road, int K) {
        Graph g = new Graph(N);
        for(int[] r : road) {
            g.input(r[0], r[1], r[2]);
        }
        return g.dijkstra(1,K);
    }

    static class Graph {
        private int n; // 노드들의 수
        private int maps[][]; // 노드들간의 가중치 저장할 변수

        public Graph(int n) {
            this.n = n;
            maps = new int[n + 1][n + 1];
        }
        public void input(int i, int j, int w) {
            if(maps[i][j] != 0) { // 초기값(0)이 아니면
                if(maps[i][j]>w){ // 더 작은 수(비용)로 초기화
                    maps[i][j] = w;
                    maps[j][i] = w;
                }
            } else { // 초기값(0)이면
                maps[i][j] = w;
                maps[j][i] = w;
            }
        }

        public int dijkstra(int v, int K) {
            int answer = 0;
            int cost[] = new int[n + 1]; // 최단 거리를 저장할 배열
            boolean[] visited = new boolean[n + 1]; // 해당 노드를 방문했는지 확인할 배열

            // cost 값 초기화
            for (int i = 1; i < n + 1; i++) {
                cost[i] = Integer.MAX_VALUE;
            }

            // 시작노드 값 초기화.
            cost[v] = 0;
            visited[v] = true;

            // 연결된 노드 cost 값 갱신
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && maps[v][i] != 0) { // 방문하지 않았고, 연결되어 있는 경우
                    cost[i] = maps[v][i];
                }
            }

            for (int a = 0; a < n - 1; a++) {
                // 원래는 모든 노드가 true 될 때까지인데
                // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
                // 원하지 않으면 각각의 노드가 모두 true 인지 확인하는 식으로 구현해도 된다.
                int min = Integer.MAX_VALUE;
                int min_index = -1;

                // 최소값 찾기
                for (int i = 1; i < n + 1; i++) {
                    if (!visited[i] && cost[i] != Integer.MAX_VALUE) { // 방문하지 않았고, 연결되어 있는 경우
                        if (cost[i] < min) {
                            min = cost[i];
                            min_index = i;
                        }
                    }
                }
                visited[min_index] = true;

                for (int i = 1; i < n + 1; i++) {
                    if (!visited[i] && maps[min_index][i] != 0) { // 방문하지 않았고, 최소값으로 연결된 노드와 연결되어 있는 경우
                        if (cost[i] > cost[min_index] + maps[min_index][i]) {
                            cost[i] = cost[min_index] + maps[min_index][i];
                        }
                    }
                }
            }

            // 결과값 출력
            for (int i = 1; i < n + 1; i++) {
                if(cost[i] <= K) {
                    answer++;
                }
            }
            return answer;

        }
    }
}
