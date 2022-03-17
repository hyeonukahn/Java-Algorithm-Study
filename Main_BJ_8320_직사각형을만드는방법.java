import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			int maxD = (int) Math.sqrt(i);
			for (int j = 1; j <= maxD; j++) {
				if(i%j==0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		br.close();
	}

}
