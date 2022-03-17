import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5469_IronBar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc_n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= tc_n; tc++) {
			String str = br.readLine();
			int ans = 0, cnt = 0;
			
			str = str.replace("()", "L");
			
			char[] chArr = str.toCharArray();
			
			for (int i = 0; i < chArr.length; i++) {
				switch (chArr[i]) {
				case '(':
					ans++;
					cnt++;
					break;
				case ')':
					cnt--;
					break;
				default:
					ans += cnt;
					break;
				}
				
			}
			sb.append("#"+tc);
			sb.append(" "+ans);
			sb.append("\n");
		}
		System.out.println(sb);
			
		br.close();
	}
}
