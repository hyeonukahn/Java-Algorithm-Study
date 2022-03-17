import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] extime = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			extime[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(extime);
		
		int tmpsum = 0;
		for (int i = 0; i < extime.length; i++) {
			tmpsum += extime[i];
			ans += tmpsum;
		}		
		
		System.out.println(ans);
		
		br.close();
	}

}
