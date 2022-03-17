import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_9663_NQueen_3 {
	static int cnt;
	static boolean[] isSelectedc;
	static int[] selC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		isSelectedc = new boolean[n];
		selC = new int[n];
		Arrays.fill(selC, -1);
		
		findNQ(0, 0, n);
		
		sb.append(cnt);
		System.out.println(sb);
		br.close();
	}
	
	static void findNQ(int r, int c, int n) {
		if(r == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(isSelectedc[i] == true || isDigonal(r, i)) {
				continue;
			}
			isSelectedc[i] = true;
			selC[r] = i;
			findNQ(r+1, c, n);
			selC[r] = -1;
			isSelectedc[i] = false;
		}
	}

	private static boolean isDigonal(int r, int c) {
		for (int i = 0; i < r; i++) {
			if(Math.abs(selC[i]-c)==(r-i)) return true;
		}
		return false;
	}
}
