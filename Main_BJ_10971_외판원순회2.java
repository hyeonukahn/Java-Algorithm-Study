import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2 {
	
	static int[] selected_City;
	static boolean[] isSelected;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		selected_City = new int[n];
		isSelected = new boolean[n];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			isSelected[i] = true;
			selected_City[0] = i;
			permu(i, 1, n, 0, board);
			isSelected[i] = false;
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void permu(int fCity, int cnt, int n, int dist, int[][] board) {
		if(cnt == n) {
			if(board[selected_City[cnt-1]][fCity] != 0) {
				dist += board[selected_City[cnt-1]][fCity];
				if(dist < ans) {
					ans = dist;
				}
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(isSelected[i] || board[selected_City[cnt-1]][i] == 0 || dist+board[selected_City[cnt-1]][i] > ans) {
				continue;
			}
			selected_City[cnt] = i;
			isSelected[i] = true;
			permu(fCity, cnt+1, n, dist+board[selected_City[cnt-1]][i], board);			
			isSelected[i] = false;
		}
		
		
		
	}

}
