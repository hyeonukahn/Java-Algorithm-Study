import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N_M_2 {
	
	static int n, m;
//	static int[] numArr;
	static int[] selArr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[n];
		selArr = new int[m];
		
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = i+1;
		}

		combination(0,0, numArr);
		
		System.out.println(sb);
		
		br.close();
	}
	
	
	public static void combination(int cnt, int start, int[] numArr) {
		if(cnt==m) {
			for (int i = 0; i < selArr.length; i++) {
				sb.append(selArr[i]+" ");
			}
			sb.append("\n");
//			sb.append(+" "+).append("\n");
			return;
		}
		
		for (int i = start; i < n; i++) {
			selArr[cnt] = numArr[i];
			combination(cnt+1, i+1, numArr);
		}
		
	}
}
