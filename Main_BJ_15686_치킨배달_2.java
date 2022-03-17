import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_15686_치킨배달_2 {
	static class Chicken{
		int x, y;
		public Chicken(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int ans = Integer.MAX_VALUE;
	static int[][] board;
	static Chicken[] selectedchicken;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		selectedchicken = new Chicken[m];
		ArrayList<Chicken> chickenList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					board[i][j] = 0;
					chickenList.add(new Chicken(i, j));
				}
			}
		}
		
		combi(0, 0, m, chickenList);
		System.out.println(ans);
		br.close();
	}
	
	static void combi(int startp, int cnt, int m, ArrayList<Chicken> chickenList) {
		if(cnt == m) {
			bfs(m, board);
			return;
		}
		
		for (int i = startp; i < chickenList.size(); i++) {
			selectedchicken[cnt] = chickenList.get(i);
			combi(i+1, cnt+1, m, chickenList);			
		}
	}
	
	static void bfs(int m, int[][] board) {
		int distsum = 0;
		int n = board.length;
		int[][] visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			visited[i] = board[i].clone();
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			visited[selectedchicken[i].x][selectedchicken[i].y] = -1;
			q.add(new int[] {selectedchicken[i].x, selectedchicken[i].y, 0});
		}
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for (int d = 0; d < dx.length; d++) {
				int mx = p[0] + dx[d];
				int my = p[1] + dy[d];
				
				if(0 <= mx && mx < n && 0 <= my && my < n && visited[mx][my] != -1) {
					if(visited[mx][my] == 1) distsum += p[2]+1;
					visited[mx][my] = -1;
					q.add(new int[] {mx, my, p[2]+1});
				}
			}
		}
		if(distsum < ans) ans = distsum;
	}
}
