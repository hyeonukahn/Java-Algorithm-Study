import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11053_가장긴증가수열_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ansArr = new int[n];
		int cnt = 1;
		ansArr[0] = cnt;
		
		for (int i = 1; i < n; i++) {
			cnt = 1;
			for (int j = i-1; j >= 0; j--) {
				if(numArr[i] > numArr[j]) {
					if(ansArr[j]+1 > cnt) {
						cnt = ansArr[j]+1;
					}
				}
			}
			ansArr[i] = cnt;
//			if(numArr[i-1] < numArr[i]) {
//				for (int j = i-1; j >= 0; j--) {
//					if(numArr[i] > numArr[j]) {
//						if(ansArr[j]+1 > cnt) {
//							cnt = ansArr[j]+1;
//						}
//					}
//				}
//				ansArr[i] = cnt;
//			} else {
//				cnt = 1;
//				for (int j = i-1; j >= 0; j--) {
//					if(numArr[i] > numArr[j]) {
//						if(ansArr[j]+1 > cnt) {
//							cnt = ansArr[j]+1;
//						}
//					}
//				}
//				ansArr[i] = cnt;
//			}
		}
		
		int ans = 0;
		for (int i = 0; i < ansArr.length; i++) {
			if(ansArr[i] > ans) {
				ans = ansArr[i];
			}
		}
		System.out.println(ans);
		
		br.close();
	}

}
