import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] tempArr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tempArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0, sum = 0;
		for (int i = 0; i < k; i++) {
			max += tempArr[i];
		}
		sum = max;
		
		for (int i = 0; i < n-k; i++) {
			sum -= tempArr[i];
			sum += tempArr[i+k];
			if(sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
		
		br.close();
	}

}
