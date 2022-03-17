import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JA_1681_해밀턴순환 {
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine().trim());
		
		visited = new boolean[n];
		
		int[][] adjMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
//		System.out.println(n);
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}
		
		permu(0, 0, 1, n, adjMatrix);
		
		System.out.println(ans);
		br.close();
	}
	
	static void permu(int cur, int dist, int cnt, int n, int[][] adjMatrix) {
		if(cnt == n) {
			if(adjMatrix[cur][0] != 0) {
				dist += adjMatrix[cur][0];
				if(dist < ans) {
					ans = dist;
				}
			}
			return;
		}
		
		for (int i = 1; i < n; i++) {
			if(visited[i] == true) {
				continue;
			}
			if(adjMatrix[cur][i] != 0 && dist < ans) {
				visited[i] = true;
				permu(i, dist+adjMatrix[cur][i], cnt+1, n, adjMatrix);
				visited[i] = false;
			}
		}
	}
}
/*
5 
0 14 4 10 20 
14 0 7 8 7 
4 5 0 7 16 
11 7 9 0 2 
18 7 17 4 0
*/
