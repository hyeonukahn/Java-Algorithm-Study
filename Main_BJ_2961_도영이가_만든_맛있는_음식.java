import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2961_도영이가_만든_맛있는_음식 {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] sourArr = new int[n];
		int[] bittArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sourArr[i] = Integer.parseInt(st.nextToken());
			bittArr[i] = Integer.parseInt(st.nextToken());
		}
		findCook(0, 0, 1, n, sourArr, bittArr);
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void findCook(int cur, int bitsum, int soursum, int n, int[] sourArr, int[] bittArr) {
		if(cur == n) {
			if(bitsum == 0) return;
			if(Math.abs(bitsum-soursum) < ans) {
				ans = Math.abs(bitsum-soursum);
			}
			return;
		}
		cur++;
		findCook(cur, bitsum, soursum, n, sourArr, bittArr);
		findCook(cur, bitsum+bittArr[cur-1], soursum*sourArr[cur-1], n, sourArr, bittArr);
		
	}
}
