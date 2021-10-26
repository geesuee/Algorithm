// [프로그래머스] 섬 연결하기
// https://programmers.co.kr/learn/courses/30/lessons/42861
// 참고 : https://suhyeokeee.tistory.com/178, https://velog.io/@kimdukbae/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%84%AC-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0-Java

package week11;

import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Q1_42861 {
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};

        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        pq = new PriorityQueue<Edge>();

        // 정점들의 부모 설정
        // 초기 연결관계는 자기자신으로 설정
        // 1 -> 2 -> 3 연결된 경우
        // 1의 부모는 2, 2의 부모는 3, 3의 부모는 3
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 비용 적은 순서부터 우선순위 큐에 삽입
        for (int[] cost : costs) {
            pq.add(new Edge(cost[0], cost[1], cost[2]));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            // 정점의 부모가 같으면 건너뛰고 (사이클이 형성된 것으로 판단)
            // 정점의 부모가 다르면 정점의 부모 변경하여 연결되어 있음 표시
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.cost;
            }
        }

        return answer;
    }

    // find --> 정점의 부모를 찾아줌.
    public static int find(int p) {
        if (parent[p] == p) {
            return p;
        }
        // 재귀로 타고 올라가 최종적으로 연결된 부모 찾음
        return parent[p] = find(parent[p]);
    }

    // union --> 정점의 부모를 변경시킴으로써 서로 연결되었다는 것을 표시해줌.
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
