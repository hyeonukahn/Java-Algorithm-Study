import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10157_자리배정_2 {
	
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
		} else {
			int x = r;
			int y = 0;
			int d = 0;
			int cnt = 0;
			
			while(cnt < r*c) {
				int mx = x+dx[d%4];
				int my = y+dy[d%4];
				System.out.println(mx+" "+my);
				if(0 <= mx && mx < r && 0 <= my && my < c && board[mx][my] == 0) {
					board[mx][my] = cnt;
					cnt++;
					x = mx;
					y = my;
					if(cnt == k) {
						break;
					}
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
