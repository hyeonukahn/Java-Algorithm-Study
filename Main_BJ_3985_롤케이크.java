import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3985_롤케이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int[] rollcake = new int[l+1];
		int wantmax = 0;
		int wantp = 0;
		int realmax = 0;
		int realp = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(wantmax < (b-a+1)) {
				wantmax = b-a+1;
				wantp = i;
			}
			
			int cnt = 0;
			for (int j = a; j <= b; j++) {
				if(rollcake[j] == 0) {
					rollcake[j] = i;
					cnt++;
				}
			}
			if(realmax < cnt) {
				realmax = cnt;
				realp = i;
			}
		}
		
		System.out.println(wantp);
		System.out.println(realp);
		
		br.close();		
	}

}
