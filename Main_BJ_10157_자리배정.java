import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10157_자리배정 {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		int[][] board = new int[r][c];
		
		if(k > r*c) {
			sb.append(0);
//			System.out.println("0");
		} else {
			int x = r-1;
			int y = 0;
			int d = 0;
			int cnt = 1;
			board[x][y] = cnt;
			
			while(cnt < r*c) {
				int mx = x+dx[d%4];
				int my = y+dy[d%4];
				if(0 <= mx && mx < r && 0 <= my && my < c && board[mx][my] == 0) {
					if(cnt == k) {
						break;
					}
					cnt++;
					board[mx][my] = cnt;
					x = mx;
					y = my;
				} else {
					d++;
				}
			}
			
			sb.append((y+1)+" ");
			sb.append((r-x));
//			System.out.println((y+1)+" "+(r-x));
			
		}
		System.out.println(sb);
//		for (int i = 0; i < board.length; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		
		br.close();
	}
}
