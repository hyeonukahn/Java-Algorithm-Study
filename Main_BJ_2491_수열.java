import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2491_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int curN = numArr[0];
		int maxcnt = cnt;

		boolean isincrease = false;
		boolean isdecrease = false;
		for (int i = 0; i < n; i++) {
			if(curN < numArr[i]) {
				curN = numArr[i];
				if(isdecrease) {
					isdecrease = false;
					if(cnt > maxcnt) {
						maxcnt = cnt;
					}
					cnt = 1;
				}
				isincrease = true;
				cnt++;
			} else if(curN > numArr[i]) {
				curN = numArr[i];
				if(isincrease) {
					isincrease = false;
					if(cnt > maxcnt) {
						maxcnt = cnt;
					}
					cnt = 1;
				}
				isdecrease = true;
				cnt++;
			} else {
				cnt++;
			}
		}
		
		System.out.println(maxcnt);

		br.close();
	}

}
