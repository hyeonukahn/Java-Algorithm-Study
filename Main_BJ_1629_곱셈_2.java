import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1629_곱셈_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> numList = new ArrayList<>();
		long res = a;
		numList.add((int)res);
		int maxC=0;
		for (long i = 2; i <= b; i=i*2) {
			res = res*res%c;
			numList.add((int)res);
			maxC = (int) i;
		}
		
		long ans=1;
		for (int i = numList.size()-1; i >= 0; i--) {
			if(b-maxC>=0) {
				ans = ans*numList.get(i);
				ans = ans%c;
				b -= maxC;
				if(b==0) break;
			}
			maxC /= 2;
		}
		sb.append(ans);
		System.out.println(sb);

		br.close();
	}
}
