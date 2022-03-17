import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15652_N_M_5 {
	
	static int n, m;
//	static int[] numArr;
	static int[] selArr;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[n];
		isSelected = new boolean[n];
		selArr = new int[m];
		st = new StringTokenizer(br.readLine());
		
		
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);

		permu(0, numArr);
		
		System.out.println(sb);
		
		br.close();
	}
	
	
	public static void permu(int cnt, int[] numArr) {
		if(cnt==m) {
			for (int i = 0; i < selArr.length; i++) {
				sb.append(selArr[i]+" ");
			}
			sb.append("\n");
//			sb.append(+" "+).append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			selArr[cnt] = numArr[i];
			
			if(isSelected[i]) continue;
			isSelected[i] = true;
			
			permu(cnt+1, numArr);
			isSelected[i] = false;
		}
		
	}
}
