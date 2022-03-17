import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_14002_가장긴증가수열4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ansArr = new int[n];
		int cnt = 1;
		boolean[][] isUsed = new boolean[n][n];
		ansArr[0] = cnt;
		boolean isStartAgain = true;
		isUsed[0][0] = true;
		
		for (int i = 1; i < n; i++) {
			cnt = 1;
			for (int j = i-1; j >= 0; j--) {
				if(numArr[i] > numArr[j]) {
					if(ansArr[j]+1 > cnt) {
						isUsed[i] = isUsed[j].clone();
						cnt = ansArr[j]+1;
					}
				}
			}
			isUsed[i][i] = true;
			ansArr[i] = cnt;
		}
		int ans = 0;
		int curIdx = 0;
		for (int i = 0; i < ansArr.length; i++) {
			if(ansArr[i] > ans) {
				ans = ansArr[i];
				curIdx = i;
			}
		}
		sb.append(ans+"\n");
		for (int i = 0; i < n; i++) {
			if(isUsed[curIdx][i]) sb.append(numArr[i]+" ");
		}
		sb.setLength(sb.length()-1);
//		sb.append("\n");
//		System.out.println(ans);
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(isUsed[i]));
//		}
		System.out.println(sb);
		
		br.close();
	}

}
