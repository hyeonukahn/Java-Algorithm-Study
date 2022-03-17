import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1259_펠린드룸 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			char[] str = br.readLine().toCharArray();
			if(str[0] == '0' && str.length == 1) {
				break;
			}
			
			boolean ispel = true;
			for (int i = 0; i < str.length; i++) {
				if(str[i] != str[str.length-1-i]) {
					ispel = false;
					break;
				}
			}
			
			if(ispel) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
