import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JA_1037_오류교정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] parityrow = new int[n];
		int[] paritycol = new int[n];
		
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += board[i][j];
			}
			parityrow[i] = sum;
		}
		
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += board[j][i];
			}
			paritycol[i] = sum;
		}
		
		boolean isEvenR = true;
		boolean doomed = false;
		int r = -1;
		for (int i = 0; i < n; i++) {
			if(parityrow[i]%2 != 0) {
				if(!isEvenR){
					doomed = true;
					break;
				}
				isEvenR = false;
				r = i;
			}
		}
		
		boolean isEvenC = true;
		int c = -1;
		for (int i = 0; i < n; i++) {
			if(paritycol[i]%2 != 0) {
				if(!isEvenC){
					doomed = true;
					break;
				}
				isEvenC = false;
				c = i;
			}
		}
		
		if (doomed) {
			System.out.println("Corrupt");
		} else if(r != -1 && c != -1) {
			System.out.println("Change bit ("+(r+1)+","+(c+1)+")");
		} else {
			System.out.println("OK");
		}
		
		br.close();
	}
}
