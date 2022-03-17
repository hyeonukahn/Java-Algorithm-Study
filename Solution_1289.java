import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		String str = "";
		int cnt;
		char curN;
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 1; i <= test_case; i++) {
            cnt = 0;
            curN = '0';
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)!=curN) {
					cnt++;
					curN=str.charAt(j);
				}
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}

//switch byte short int char String
//instance of, 8개 형태.
// 생성자 주의. 생성자 앞에 형태 붙이면 더이상 생성자 아님...
// extends Object
// abstract final static
// public protected default private
// 서로다른패키지             같은 패키지
// this() super() 함께 사용 불가.
