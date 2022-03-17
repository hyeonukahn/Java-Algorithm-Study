
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_9251_LCS_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		int ans = 0;
		int n = str1.length();
		int m = str2.length();
		int[][] board = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					board[i][j] = board[i-1][j-1]+1;
				}
			}
		}
		
		ans = board[n][m];
		
		System.out.println(ans);
		br.close();
	}

}

/*
ABCDED
ABCDDE
*/