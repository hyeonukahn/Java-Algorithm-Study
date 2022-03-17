import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕 {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
		int airbottomIdx = 0;
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == -1) {
					airbottomIdx = i;
				}
			}
		}
//		System.out.println(airbottomIdx);
		
		
		
		for (int i = 0; i < t; i++) {
			spreadAndAir(r, c, airbottomIdx);
//			for (int j = 0; j < r; j++) {
//				System.out.println(Arrays.toString(board[j]));
//			}
//			System.out.println();
		}
		
		int ans = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				ans += board[i][j];
			}
		}
		ans += 2;
		
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void spreadAndAir(int r, int c, int airbottomIdx) {
		int[][] afterSpread = new int[r][c];
		afterSpread[airbottomIdx][0] = -1;
		afterSpread[airbottomIdx-1][0] = -1;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(board[i][j] > 0) {
					int spreadAmount = board[i][j]/5;
					for (int d = 0; d < dx.length; d++) {
						int mx = i+dx[d];
						int my = j+dy[d];
						if(0 <= mx && mx < r && 0 <= my && my < c && board[mx][my] != -1) {
							afterSpread[mx][my] += spreadAmount;
							board[i][j] -= spreadAmount;
						}
					}
					afterSpread[i][j] += board[i][j];
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				board[i][j] = afterSpread[i][j];
			}
		}
		
		int d = 0;
		int x = airbottomIdx-1;
		int y = 0;
		while(d<4) {
			int mx = x+dx[d];
			int my = y+dy[d];
			if(0 <= mx && mx < airbottomIdx && 0 <= my && my < c) {
				board[x][y] = board[mx][my];
				x = mx;
				y = my;
			}
			else {
				d++;
			}
		}
		board[airbottomIdx-1][1] = 0;
		board[airbottomIdx-1][0] = -1;
		
		d = 2;
		x = airbottomIdx;
		y = 0;
		int cnt = 0;
		while(cnt < 4) {
			int mx = x+dx[d];
			int my = y+dy[d];
			if(airbottomIdx <= mx && mx < r && 0 <= my && my < c) {
				board[x][y] = board[mx][my];
				x = mx;
				y = my;
			}
			else {
				d--;
				if(d == -1) d = 3;
				cnt++;
			}
		}
		board[airbottomIdx][1] = 0;
		board[airbottomIdx][0] = -1;
		
//		for (int i = 0; i < r; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
//		System.out.println();
	}
	
}
