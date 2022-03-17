import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IronBar_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 0, cnt = 0;
		
		str = str.replace("()", "L");
		char c;
		
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			switch (c) {
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
		System.out.println(ans);
		br.close();
	}
}
