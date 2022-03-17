import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_BJ_10026_적록색약_2 {
	static char[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] board = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visited = new char[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(board[i], 0, visited[i], 0, n);
		}
		
		boolean isbfs = true;
		int cnt = -1;
		while(isbfs) {
			cnt++;
			isbfs = bfs(n);
		}
		sb.append(cnt+" ");
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 'R') {
					board[i][j] = 'G';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.arraycopy(board[i], 0, visited[i], 0, n);
		}
		
		isbfs = true;
		cnt = -1;
		while(isbfs) {
			cnt++;
			isbfs = bfs(n);
		}
		sb.append(cnt);
		
		System.out.println(sb);
		
		br.close();
	}
	
	
	static boolean bfs(int n) {
		
		char chkchar = 'N';
		int startx = -1;
		int starty = -1;
		
		outer:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j] != 'X') {
					chkchar =  visited[i][j];
					startx = i;
					starty = j;
					break outer;
				}
			}
		}
		
		if(chkchar == 'N') {
			return false;
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {startx, starty});
		visited[startx][starty] = 'X';
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for (int d = 0; d < dx.length; d++) {
				int mx = p[0]+dx[d];
				int my = p[1]+dy[d];
				if(0 <= mx && mx < n && 0 <= my && my < n && visited[mx][my] == chkchar) {
					visited[mx][my] = 'X';
					q.add(new int[] {mx, my});
				}
			}
		}
		
		return true;
	}
}
