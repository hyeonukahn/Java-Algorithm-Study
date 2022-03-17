import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS_BFS {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[n+1][n+1]; 
		boolean[] visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		dfs(v, n, adjMatrix, visited);
		sb.append("\n");
		bfs(v, n, adjMatrix);
		
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int v, int n, int[][] adjMatrix, boolean[] visited) {
		visited[v] = true;
		sb.append(v+" ");
		for (int i = 1; i <= n; i++) {
			if(!visited[i] && adjMatrix[v][i] == 1) {
				dfs(i, n, adjMatrix, visited);
			}
		}
	}

	private static void bfs(int start, int n, int[][] adjMatrix) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		boolean[] visited = new boolean[n+1];
		visited[start] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x+" ");
			for (int i = 1; i <= n; i++) {
				if(!visited[i] && adjMatrix[x][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

}
