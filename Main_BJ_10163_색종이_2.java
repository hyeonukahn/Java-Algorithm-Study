import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10163_색종이_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dowhaghi = new int[1001][1001];
//		int x1, y1, x2, y2;
		int[][] inputArr = new int[n+1][4];
				
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			inputArr[i][0] = Integer.parseInt(st.nextToken());
			inputArr[i][1] = Integer.parseInt(st.nextToken());
			inputArr[i][2] = Integer.parseInt(st.nextToken());
			inputArr[i][3] = Integer.parseInt(st.nextToken());
		}
		
//		for (int i = 1; i < inputArr.length; i++) {
//			System.out.println(Arrays.toString(inputArr[i]));
//		}
		
		for (int i = 1; i < inputArr.length; i++) {
			
			for (int j = inputArr[i][0]; j < inputArr[i][0]+inputArr[i][2]; j++) {
				for (int k = inputArr[i][1]; k < inputArr[i][1]+inputArr[i][3]; k++) {
					dowhaghi[j][k] = i;
				}
			}
		}
		
		int[] ansArr = new int[n+1];
		for (int i = 0; i < dowhaghi.length; i++) {
			for (int j = 0; j < dowhaghi[i].length; j++) {
				ansArr[dowhaghi[i][j]]++;
			}
		}
		
		for (int i = 1; i < ansArr.length; i++) {
			sb.append(ansArr[i]).append("\n");
		}
		System.out.println(sb);
		
//		System.out.println(Arrays.toString(ansArr));
		
		
		br.close();		
	}

}
