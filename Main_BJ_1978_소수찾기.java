import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> primeN = new ArrayList<>();
		primeN.add(2);
		
		for (int i = 3; i <= 1000; i++) {
			boolean isprime = true;
			for (int p : primeN) {
				if(i%p == 0) {
					isprime = false;
					break;
				}
			}
			if(isprime) {
				primeN.add(i);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int p : primeN) {
				if(num < p) {
					break;
				} else if(num == p) {
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
