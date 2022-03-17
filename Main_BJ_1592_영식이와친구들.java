import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] ballcnt = new int[n+1];
		int cur = 1;
		ballcnt[cur] = 1;
		int cnt = 0;
		while(ballcnt[cur] != m) {
			if(ballcnt[cur] % 2 == 1) {
				cnt++;
				cur += l;
				if(cur > n) {
					cur -= n;
				}
				ballcnt[cur]++;
			} else {
				cnt++;
				cur -= l;
				if(cur < 1) {
					cur += n;
				}
				ballcnt[cur]++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
