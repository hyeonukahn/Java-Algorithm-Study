import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2491_수열_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numArr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ansArr = new int[n+1];
		int curN = numArr[1];
		int cnt = 1;
		ansArr[1] = 1;
		int samecnt = 1;
		boolean isincrease = false;
		boolean isdecrease = false;
		for (int i = 2; i <= n; i++) {
			if(curN < numArr[i]) {
				if(isdecrease) {
					isdecrease = false;
					cnt = samecnt;
				}
				isincrease = true;
				samecnt = 1;
				curN = numArr[i];
				cnt++;
				ansArr[i] = cnt;				
			} else if(curN > numArr[i]) {
				if(isincrease) {
					isincrease = false;
					cnt = samecnt;
				}
				samecnt = 1;
				curN = numArr[i];
				cnt++;
				ansArr[i] = cnt;				
				isdecrease = true;
			} else {
				cnt++;
				ansArr[i] = cnt;
				samecnt++;
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= n ; i++) {
			if(ans < ansArr[i]) {
				ans = ansArr[i];
			}
		}
		System.out.println(ans);

		br.close();
	}

}
