import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11660_구간합구하기5{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] numArr = new int[n+2][n+2];
		int[][] sumArr = new int[n+2][n+2];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = n; i > 0; i--) {
			for (int j = n; j > 0; j--) {
				sumArr[i][j] += numArr[i][j]+sumArr[i][j+1]+sumArr[i+1][j]-sumArr[i+1][j+1];
				
			}
		}
//		
//		for (int i = 0; i < sumArr.length; i++) {
//			System.out.println(Arrays.toString(sumArr[i]));
//		}
//		
		int[] comm = new int[4];
		int sum;
//		ArrayList<int[]> calcResArr = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < comm.length; j++) {
				comm[j] = Integer.parseInt(st.nextToken());
			}
			
			sum = sumArr[comm[0]][comm[1]]-sumArr[comm[2]+1][comm[1]]-sumArr[comm[0]][comm[3]+1]+sumArr[comm[2]+1][comm[3]+1];
			
			
//			for (int j = comm[0]; j <= comm[2]; j++) {
//				for (int k = comm[1]; k <= comm[3]; k++) {
//					sum += numArr[j][k];
//				}
//			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
		br.close();		
	}

}
