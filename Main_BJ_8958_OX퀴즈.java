import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_8958_OX퀴즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			char[] chArr = br.readLine().toCharArray();
			int ans = 0, cnt = 0;
			for (int j = 0; j < chArr.length; j++) {
				if(chArr[j] == 'O') ans += ++cnt;
				else cnt = 0;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
