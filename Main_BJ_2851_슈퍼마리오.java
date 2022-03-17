import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2851_슈퍼마리오 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 10;
		int[] mushArr = new int[n];
		for (int i = 0; i < n; i++) {
			mushArr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		int diff = 100;
		for (int i = 0; i < n; i++) {
			sum += mushArr[i];
			if(Math.abs(100-sum) <= diff) {
				diff = Math.abs(100-sum);
			} else {
				sum -= mushArr[i];
				break;
			}
		}
		
		System.out.println(sum);
		
		br.close();
	}

}
