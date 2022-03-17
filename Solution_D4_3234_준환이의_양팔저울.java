import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의_양팔저울 {
	static boolean[] isSelected;
	static int[] selectednum;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= tc_n; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] weight = new int[n];
			isSelected = new boolean[n];
			selectednum = new int[n];
			ans = 0;
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			permu(0, n, weight);
			
			sb.append("#"+tc);
			sb.append(" "+ans);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void permu(int cnt, int n, int[] weight) {
		if(cnt == n) {
			LeftRight(0, 0, 0, n, selectednum);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(isSelected[i]) continue;
			selectednum[cnt] = weight[i];
			isSelected[i] = true;
			permu(cnt+1, n, weight);
			isSelected[i] = false;
		}
	}
	
	static void LeftRight(int idx, int lsum, int rsum, int n, int[] selArr) {
		if(idx == n) {
			ans++;
			return;
		}
		
		LeftRight(idx+1, lsum+selArr[idx], rsum, n, selArr);
		if(rsum+selArr[idx] <= lsum) {
			LeftRight(idx+1, lsum, rsum+selArr[idx], n, selArr);
		}
	}
}
