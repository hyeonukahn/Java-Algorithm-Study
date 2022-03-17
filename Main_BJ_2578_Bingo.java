import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2578_Bingo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 5;
		int[][] bingoboard = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				bingoboard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] callNum = new int[n*n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				callNum[i*n+j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < n*n; i++) {
			int cnt = 0;
			int num = callNum[i];
			
			bingo:
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(bingoboard[j][j2] == num) {
						bingoboard[j][j2] = 0;
						break bingo;
					}
				}
			}
			
			for (int j = 0; j < n; j++) {
				boolean bingo = true;
				for (int j2 = 0; j2 < n; j2++) {
					if(bingoboard[j][j2] != 0) {
						bingo = false;
						break;
					}
				}
				if(bingo) {
					cnt++;
				}
			}
			
			for (int j = 0; j < n; j++) {
				boolean bingo = true;
				for (int j2 = 0; j2 < n; j2++) {
					if(bingoboard[j2][j] != 0) {
						bingo = false;
						break;
					}
				}
				if(bingo) {
					cnt++;
				}
			}
			
			boolean bingocross = true;
			for (int j = 0; j < n; j++) {
				if(bingoboard[j][j] != 0) {
					bingocross = false;
					break;
				}
			}
			if (bingocross) {
				cnt++;
			}
			
			bingocross = true;
			for (int j = 0; j < n; j++) {
				if(bingoboard[(n-1)-j][j] != 0) {
					bingocross = false;
					break;
				}
			}
			if (bingocross) {
				cnt++;
			}
			
			if(cnt >= 3) {
				ans = i+1;
				break;
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
