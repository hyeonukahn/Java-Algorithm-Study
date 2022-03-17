import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2839_설탕배달_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int ans=-1;
		int n = Integer.parseInt(br.readLine());
		
		int sug5 = n/5;
		int sug3 = n/3;
		
		outer:
		for (int i = sug5; i <= sug3+1; i++) {
			for (int j = 0; j <= i; j++) {
				if(j*5+(i-j)*3 == n) {
					ans = i;
					break outer;
				}
			}
		}
		System.out.println(ans);
		
		br.close();
	}

}
