import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] numArr = new int[n][n];
		
		for (int i = 0; i < numArr.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < numArr.length; j++) {
				numArr[i][j] = str.charAt(j)-'0';
			}
		}
		
//		for (int i = 0; i < numArr.length; i++) {
//			System.out.println(Arrays.toString(numArr[i]));
//		}
		divQuan(n, numArr);
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void divQuan(int n, int[][] numArr) {
		if(n==1) {
			sb.append(numArr[0][0]);
			return;
		}
		
		int numchk = numArr[0][0];
		boolean chk = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(numArr[i][j] != numchk) {
					chk = false;
					break;
				}
			}
		}
		
		if(!chk) {
			sb.append("(");
			int[][] inArr = new int[n/2][n/2];
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					inArr[i][j] = numArr[i][j];
				}
			}
			divQuan(n/2, inArr);
			
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					inArr[i][j] = numArr[i][j+n/2];
				}
			}
			divQuan(n/2, inArr);
			
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					inArr[i][j] = numArr[i+n/2][j];
				}
			}
			divQuan(n/2, inArr);
			
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					inArr[i][j] = numArr[i+n/2][j+n/2];
				}
			}
			divQuan(n/2, inArr);
			sb.append(")");
		} else {
			sb.append(numchk);
		}
	}
}
