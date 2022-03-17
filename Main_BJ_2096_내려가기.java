import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] minval = new int[n][3];
		int[][] maxval = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				minval[i][j] = board[i][j];
				maxval[i][j] = board[i][j];
				
				if(i > 0) {
					int mintmp = minval[i-1][j];
					int maxtmp = maxval[i-1][j];
					if(0 <= j-1) {
						mintmp = Math.min(mintmp, minval[i-1][j-1]);
						maxtmp = Math.max(maxtmp, maxval[i-1][j-1]);
					}
					if(j+1 < 3) {
						mintmp = Math.min(mintmp, minval[i-1][j+1]);
						maxtmp = Math.max(maxtmp, maxval[i-1][j+1]);
					}
					minval[i][j] += mintmp;
					maxval[i][j] += maxtmp;
				}
			}
		}
		
		int minans = minval[n-1][0];
		int maxans = maxval[n-1][0];
		for (int i = 1; i < 3; i++) {
			minans = Math.min(minans, minval[n-1][i]);
			maxans = Math.max(maxans, maxval[n-1][i]);
		}
		
		sb.append(maxans+" ").append(minans);
		
		System.out.println(sb);
		br.close();
	}

}
