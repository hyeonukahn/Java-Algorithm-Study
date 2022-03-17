import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n; j++) {
				for (int j2 = j+1; j2 < n; j2++) {
					sum = numArr[i]+numArr[j]+numArr[j2];
					if(sum<=m && ans < sum) {
						ans = sum;
					}
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
