import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_3040_백설공주 {
	static int[] selNan = new int[7];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] allNan = new int[9];
		for (int i = 0; i < 9; i++) {
			allNan[i] = Integer.parseInt(br.readLine());
		}
		combi(0, 0, 7, 9, allNan);
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void combi(int startP, int cnt, int r, int n, int[] allNan) {
		if(cnt == r) {
			int sum = 0;
			for (int i = 0; i < r; i++) {
				sum += selNan[i];
			}
			if(sum == 100) {
				for (int i = 0; i < r; i++) {
					sb.append(selNan[i]+"\n");
				}
			}
			return;
		}
		
		for (int i = startP; i < n; i++) {
			selNan[cnt] = allNan[i];
			combi(i+1, cnt+1, r, n, allNan);
		}
		
	}
	
}
