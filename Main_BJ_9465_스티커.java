import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < tc_n; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] fLine = new int[n];
			int[] sLine = new int[n];
			int[][] ansArr = new int[n][2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				fLine[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				sLine[i] = Integer.parseInt(st.nextToken());
			}
			ansArr[0][0] = fLine[0];
			ansArr[0][1] = sLine[0];
			for (int i = 1; i < n; i++) {
				if(ansArr[i-1][0] > ansArr[i-1][1]+fLine[i]) {
					ansArr[i][0] = ansArr[i-1][0];
				} else {
					ansArr[i][0] = ansArr[i-1][1]+fLine[i];
				}
				
				if(ansArr[i-1][1] > ansArr[i-1][0]+sLine[i]) {
					ansArr[i][1] =ansArr[i-1][1];
				} else {
					ansArr[i][1] = ansArr[i-1][0]+sLine[i];
				}
			}
			
//			System.out.println();
//			for (int i = 0; i < n; i++) {
//				System.out.println(ansArr[i][0]+" "+ansArr[i][1]);
//			}
			
			int ans = Math.max(ansArr[n-1][0], ansArr[n-1][1]);
			
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();		
	}

}
