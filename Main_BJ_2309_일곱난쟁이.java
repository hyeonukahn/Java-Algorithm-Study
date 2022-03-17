import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_2309_일곱난쟁이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = 9;
		int[] nan = new int[n];
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			nan[i] = Integer.parseInt(br.readLine());
			sum += nan[i];
		}
		
		int not1 = 0;
		int not2 = 0;
		Arrays.sort(nan);
		outer:
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if(sum - nan[i]- nan[j] == 100) {
					not1 = i;
					not2 = j;
					break outer;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if(i != not1 && i != not2) {
				sb.append(nan[i]+"\n");
			}
		}
		System.out.println(sb);
		
		br.close();
	}

}
