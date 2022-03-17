import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2098_외판원순회_4 {
	
	static int ans;
	static int[][] memory;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		ans = Integer.MAX_VALUE;
		memory = new int[n][(int) (Math.pow(2, n))];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memory[i], 987654321);
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memory[0][1] = 0;		
		permu(0, 0, 1, n, 0, 1<<0, board);
//		System.out.println(memory[0][(int) (Math.pow(2, n))-1]);
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void permu(int fCity, int beforeCity, int cnt, int n, int dist, int flag, int[][] board) {
		if(cnt == n) {
			if(board[beforeCity][fCity] != 0) {
				dist += board[beforeCity][fCity];
				if(dist < ans) {
					ans = dist;
				}
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if((flag & 1<<i) != 0 || board[beforeCity][i] == 0 || dist+board[beforeCity][i] > ans) {
				continue;
			}
			if(memory[i][(flag | 1 << i)] > memory[beforeCity][flag]+board[beforeCity][i]) {
				memory[i][(flag | 1 << i)] = memory[beforeCity][flag]+board[beforeCity][i];
			} else {
				continue;
			}
			permu(fCity, i, cnt+1, n, dist+board[beforeCity][i], (flag | 1 << i),board);
		}
	}
}
