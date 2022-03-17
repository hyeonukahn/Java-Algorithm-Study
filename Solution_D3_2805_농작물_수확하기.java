import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물_수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc_n = Integer.parseInt(br.readLine());
		int n;
		int[][] farmArr;
		String str;
		int L, R;
		int sum;
		boolean isIncrease;
		
		for (int tc = 1; tc <= tc_n; tc++) {
			n = Integer.parseInt(br.readLine());
			L = n/2; R = n/2;
			sum = 0;
			isIncrease = true;
			
			farmArr = new int[n][n];			
			for (int i = 0; i < n; i++) {
				str = br.readLine();
				for (int j = 0; j < n; j++) {
					farmArr[i][j] = str.charAt(j)-'0';
				}
			}
			
			for (int i = 0; i < n; i++) {
//				System.out.println("L="+L+" R="+R);
				for (int j = L; j <= R; j++) {
					sum += farmArr[i][j];
				}
				if(isIncrease) {
					L--;
					R++;
					
					if(R>=n) {
						L++;L++;
						R--;R--;
						isIncrease = false;
					}
				}
				else {
					L++;
					R--;
				}
			}
			
			
			
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(farmArr[i]));
//			}
			
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
