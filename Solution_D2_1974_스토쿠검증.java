import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_스토쿠검증 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		int n = 9;
		int[][] board;
		boolean chk = true;
		int ans = 1;
		for (int tc = 1; tc <= tc_n; tc++) {
			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			chk = chkrow(n, board);
			if(chk) {
				chk = chkcol(n, board);
			}
			if(chk) {
				chk = chkbox(n, board);
			}
			
			if(chk) ans = 1;
			else ans = 0;
			
			sb.append("#"+tc);
			sb.append(" "+ans);
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	static boolean chkrow(int n, int[][] board) {
		for (int i = 0; i < n; i++) {
			boolean[] chknum = new boolean[n+1];
			for (int j = 0; j < n; j++) {
				if(chknum[board[i][j]]) {
					return false;
				}
				chknum[board[i][j]] = true;
			}
		}
		return true;
	}
	
	static boolean chkcol(int n, int[][] board) {
		for (int i = 0; i < n; i++) {
			boolean[] chknum = new boolean[n+1];
			for (int j = 0; j < n; j++) {
				if(chknum[board[j][i]]) {
					return false;
				}
				chknum[board[j][i]] = true;
			}
		}
		return true;
	}
	
	static boolean chkbox(int n, int[][] board) {
		for (int box = 0; box < n; box++) {
			boolean[] chknum = new boolean[n+1];
			for (int i = (n+1)/3*(box/3); i < (n+1)/3*(box/3+1); i++) {
				for (int j = (n+1)/3*(box%3); j < (n+1)/3*(box%3+1); j++) {
					if(chknum[board[j][i]]) {
						return false;
					}
					chknum[board[j][i]] = true;
				}
			}
		}
		return true;
	}

}
