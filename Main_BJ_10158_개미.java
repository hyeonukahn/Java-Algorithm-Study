import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int x = p, y = q;
		if(t+p <= w) {
			x = t+p;
		} else if(((t+p)/w) %2 == 1) {
			x = ((t+p)/w+1)*w - t - p;
		} else {
			x = -((t+p)/w)*w + t + p;
		}
		sb.append(x+" ");
		
		if(t+q <= h) {
			y = t+q;
		} else if(((t+q)/h) %2 == 1) {
			y = ((t+q)/h+1)*h - t - q;
		} else {
			y = -((t+q)/h)*h + t + q;
		}
		sb.append(y);
		
		System.out.println(sb);		
		
		br.close();
	}
}
