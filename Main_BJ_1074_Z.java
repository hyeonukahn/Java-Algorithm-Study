import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1074_Z {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		findCnt(n, r, c, 0);
		
		System.out.println(sb);		
		br.close();
	}
	
	static void findCnt(int N, int r, int c, long cnt) {
		if(N==1) {
			if(r==0 && c==1) cnt += 1;
			else if(r==1 && c==0) cnt += 2;
			else if(r==1 && c==1) cnt += 3;
			sb.append(cnt);
			return;
		} else {
			N--;
			long pownum = (long) Math.pow(2, N);
			if(r>=pownum) {
				cnt += pownum*pownum*2;
				r -= pownum;
			}
			if(c>=pownum) {
				cnt += pownum*pownum;
				c -= pownum;
			}
			
			findCnt(N, r, c, cnt);
		}
	}

}
