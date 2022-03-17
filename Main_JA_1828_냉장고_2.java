import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JA_1828_냉장고_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Subst[] subArr = new Subst[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			subArr[i] = new Subst(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(subArr);
		int cnt=1;
		Subst cur=subArr[0];
		for (int i = 1; i < n; i++) {
			if(cur.high < subArr[i].low) {
				cnt++;
				cur = subArr[i];
			}
		}
		sb.append(cnt);
		System.out.println(sb);
		br.close();
	}
	
	static class Subst implements Comparable<Subst>{
		int low;
		int high;
		public Subst(int low, int high) {
			this.low = low;
			this.high = high;
		}
		
		@Override
		public int compareTo(Subst o) {
			return this.high != o.high? this.high-o.high : this.low-o.low;
		}
	}
}
