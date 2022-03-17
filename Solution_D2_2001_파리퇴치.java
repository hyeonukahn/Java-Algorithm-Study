import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc_n = Integer.parseInt(br.readLine());
		int m, n;
		int[][] flyArr;
		int sum, max;
		
		for (int tc = 1; tc <= tc_n; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			flyArr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					flyArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i+m <= n; i++) {
				for (int j = 0; j+m <= n; j++) {
					
					sum = 0;
					for (int j2 = i; j2 < i+m; j2++) {
						for (int k = j; k < j+m; k++) {
							sum += flyArr[j2][k];
						}
					}
					
					if(sum>max) {
						max = sum;						
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
//			System.out.println(max);
			
		}
		System.out.println(sb);
		
		br.close();		
	}
}
