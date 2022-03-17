import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1987_알파벳_2 {
	static int ans;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		String[] board = new String[r];
		boolean[] visited = new boolean[26]; 
		int cnt = 1;
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine();
		}
		visited[board[0].charAt(0)-'A'] = true;
		dfs(0, 0, cnt, visited, board, r, c);
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void dfs(int x, int y, int cnt, boolean[] visited, String[] board, int r, int c) {
		for (int i = 0; i < 4; i++) {
			int mx = x+dx[i];
			int my = y+dy[i];
			if(0<=mx && mx<r && 0<=my && my<c) {
				int idx = board[mx].charAt(my)-'A';
				if(!visited[idx]) {
					visited[idx]= true;
					dfs(mx, my, cnt+1, visited, board, r, c);
					visited[idx] = false;
				}
			}
		}
		if(ans < cnt) {
			ans = cnt;
		}
	}

}
